package com.example.hr_management_ship.services;

import com.example.hr_management_ship.models.UserModel;
import com.example.hr_management_ship.models.enumes.EmployeeLevel;
import com.example.hr_management_ship.models.enumes.Gender;
import com.example.hr_management_ship.repositorys.UserRepository;
import com.example.hr_management_ship.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserModel getUserByPrincipal(Principal principal) {
        if (principal == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return userRepository.findByEmail(principal.getName());
    }

    public List<UserModel> searchUserByFirstName(String firstName){
        Validator.checkFirstName(firstName);
        return userRepository.findByFirstName(firstName);
    }

    public List<UserModel> searchUserByLastName(String lastName){
        Validator.checkLastName(lastName);
        return userRepository.findByLastName(lastName);
    }

    public List<UserModel> searchUserByEmployeeLevel(EmployeeLevel employeeLevel){
        Validator.checkEmployeeLevel(employeeLevel);
        return userRepository.findByEmployeeLevel(employeeLevel);
    }

    public List<UserModel> searchUserByPosition(String position){
        return userRepository.findByPosition(position);
    }

    public List<UserModel> searchUserByGender(Gender gender){
        Validator.checkGender(gender);
        return userRepository.findByGender(gender);
    }
}
