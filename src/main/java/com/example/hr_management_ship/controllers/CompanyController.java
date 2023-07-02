package com.example.hr_management_ship.controllers;

import com.example.hr_management_ship.models.CompanyModel;
import com.example.hr_management_ship.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/signup")
    public String registration() {
        return "signup";
    }

    @PostMapping("/signup")
    public String createCompany(CompanyModel company, Model model) throws IOException {
        if (!companyService.creatCompany(company)){
            model.addAttribute("errorMessage", "Company with " + company.getEmail() + " email we have!");
            return "signup";
        }
//        companyService.creatCompany(company, file);
        return "redirect: /login";
    }
}
