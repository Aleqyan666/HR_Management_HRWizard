package com.example.hr_management_ship.controllers;

import com.example.hr_management_ship.models.UserModel;
import com.example.hr_management_ship.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final CompanyService companyService;

    @GetMapping("/registerUser")
    public String userRegistration() {
        return "user_register";
    }

    @GetMapping("/registerAdmin")
    public String adminRegistration() {
        return "admin_register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") UserModel user, Principal principal) {
        if (companyService.createUserInCompany(principal, user)) {
            return "redirect:/";
        } else {
            return "redirect:/signup?error";
        }
    }

    @PostMapping("/registerAdmin")
    public String registerAdmin(@ModelAttribute("user") UserModel user, Principal principal) {
        if (companyService.createAdminInCompany(principal, user)) {
            return "redirect:/";
        } else {
            return "redirect:/signup?error";
        }
    }
}

