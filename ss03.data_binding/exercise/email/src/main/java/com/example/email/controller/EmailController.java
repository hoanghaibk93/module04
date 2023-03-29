package com.example.email.controller;

import com.example.email.model.Email;
import com.example.email.service.IEmailService;
import com.example.email.service.impl.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    IEmailService service = new EmailService();
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("email", new Email());
        model.addAttribute("languages", service.getLanguages());
        model.addAttribute("pageSize", service.getPageSize());
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
