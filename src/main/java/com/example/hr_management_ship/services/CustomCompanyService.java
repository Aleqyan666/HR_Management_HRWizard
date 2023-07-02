package com.example.hr_management_ship.services;

import com.example.hr_management_ship.models.CompanyModel;
import com.example.hr_management_ship.repositorys.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomCompanyService implements UserDetailsService {
    private final CompanyRepository companyRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CompanyModel company = companyRepository.findByEmail(email);
        if (company == null) {
            throw new UsernameNotFoundException("Company not found!");
        }
        return User
                .withUsername(company.getEmail())
                .password(company.getPassword())
                .authorities("SUPER_ADMIN")
                .build();
    }
}
