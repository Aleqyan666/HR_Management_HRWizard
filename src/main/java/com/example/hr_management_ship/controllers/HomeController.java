package com.example.hr_management_ship.controllers;

import com.example.hr_management_ship.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    private final CompanyService companyService;
    @GetMapping("/")
    public String mainPage(Principal principal, Model model) {
        model.addAttribute("company", companyService.getCompanyByPrincipal(principal));
        return "home";
    }

}
