package com.example.hr_management_ship.controllers;

import com.example.hr_management_ship.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "profile";
    }

    @GetMapping("/admin")
    public String admin(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("users", userService.getAll(userService.getUserByPrincipal(principal)));
        return "admin";
    }
}
