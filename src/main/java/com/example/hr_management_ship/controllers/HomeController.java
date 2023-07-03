package com.example.hr_management_ship.controllers;

import com.example.hr_management_ship.services.CompanyService;
import com.example.hr_management_ship.services.UserService;
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
    private final UserService userService;
    @GetMapping("/")
    public String mainPage(Principal principal, Model model) {
        model.addAttribute("company", companyService.getCompanyByPrincipal(principal));
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "home";
    }

}
