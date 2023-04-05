package com.example.register.controller;

import com.example.register.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/user")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/user/register")
    public String register(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            model.addAttribute("user", user);
            return "result";
        }
    }
}
