package com.example.hr_management_ship.services;

import com.example.hr_management_ship.models.UserModel;
import com.example.hr_management_ship.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

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
}
