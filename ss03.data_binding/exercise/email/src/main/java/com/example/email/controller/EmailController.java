package com.example.email.controller;

import com.example.email.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("email", new Email());
        String[] languages = new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
        model.addAttribute("languages", languages);
        Integer[] pageSize = new Integer[]{5, 10, 15, 20, 100};
        model.addAttribute("pageSize", pageSize);
        return "update";
    }

    @PostMapping(value = "/email")
    public String update(@ModelAttribute("email") Email email, Model model) {
        model.addAttribute("languages", email.getLanguages());
        model.addAttribute("pageSize", email.getPageSize());
        model.addAttribute("spamsFilter", email.getSpamsFilter());
        model.addAttribute("signature", email.getSignature());
        return "info";
    }
}
