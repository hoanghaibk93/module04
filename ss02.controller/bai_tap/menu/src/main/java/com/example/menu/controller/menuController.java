package com.example.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class menuController {
    @GetMapping("/display")
    public String displayMenu() {
        return "display";
    }

    @PostMapping("/display/result")
    public String displayMenu(@RequestParam(value = "menu", required = false) String[] menu, Model model) {
        String[] menuOther = {"No choice"};
        if (menu == null) {
            model.addAttribute("menu", menuOther);
        } else {
            model.addAttribute("menu", menu);
        }
        return "display";
    }
}
