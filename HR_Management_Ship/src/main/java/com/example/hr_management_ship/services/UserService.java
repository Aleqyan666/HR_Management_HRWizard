//package com.example.hr_management_ship.services;
//
//import com.example.hr_management_ship.models.UserModel;
//import com.example.hr_management_ship.models.enumes.Role;
//import com.example.hr_management_ship.repositorys.UserRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class UserService {
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public boolean createUser(UserModel userModel) {
//        String email = userModel.getEmail();
//        if (userRepository.findByEmail(email) != null) return false;
//        userModel.setActive(true);
//        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
//        userModel.getRoles().add(Role.USER);
//        log.info("Saving new User with email: {}", email);
//        userRepository.save(userModel);
//        return true;
//    }
//}
