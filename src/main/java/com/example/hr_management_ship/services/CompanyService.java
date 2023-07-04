package com.example.hr_management_ship.services;

import com.example.hr_management_ship.models.UserModel;
import com.example.hr_management_ship.models.enumes.CompanySize;
import com.example.hr_management_ship.models.enumes.Role;
import com.example.hr_management_ship.models.CompanyModel;
import com.example.hr_management_ship.models.Image;
import com.example.hr_management_ship.repositorys.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;

    public boolean creatCompany(CompanyModel companyModel) throws IOException {
        String email = companyModel.getEmail();
        String name = companyModel.getName();
//        Image image;
        if (companyRepository.findByEmail(email) != null) return false;
//        if (file.getSize() != 0) {
//            image = toImageEntity(file);
//            companyModel.setLogo(image);
//        }
        companyModel.setPassword(passwordEncoder.encode(companyModel.getPassword()));
        companyModel.setCompanySize(CompanySize.SMALL);
        companyModel.setRole(Role.SUPER_ADMIN);
        String subject = "Company Registration Confirmation";
        String text = "Thank you for registering your company with Ship.";
        mailService.sendEmail(email, subject, text);
        log.info("Saving new Company with name: {}", name);
//        CompanyModel companyToDB = companyRepository.save(companyModel);
//        companyToDB.setLogo(companyToDB.getLogo());
        companyRepository.save(companyModel);
        return true;
    }

    public boolean createUserInCompany(Principal principal,UserModel user) {
        user.setCompany(getCompanyByPrincipal(principal));
        CompanyModel company = getCompanyByPrincipal(principal);
        if (company == null) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCompany(company);
        user.setActive(true);

        company.getUsers().add(user);
        companyRepository.save(company);

        return true;
    }

    public boolean createAdminInCompany(Principal principal, UserModel user, Long companyId) {
        user.setCompany(getCompanyByPrincipal(principal));
        CompanyModel company = companyRepository.findById(companyId).orElse(null);
        if (company == null) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ADMIN);
        user.setCompany(company);
        user.setActive(true);

        company.getUsers().add(user);
        companyRepository.save(company);

        return true;
    }

    public CompanyModel getCompanyByPrincipal(Principal principal){
        if (principal == null) {
            throw new UsernameNotFoundException("Company not found!");
        }
        return companyRepository.findByEmail(principal.getName());
    }

    public Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
}
