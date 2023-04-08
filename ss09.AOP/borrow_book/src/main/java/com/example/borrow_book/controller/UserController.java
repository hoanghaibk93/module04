package com.example.borrow_book.controller;

import com.example.borrow_book.service.IBookService;
import com.example.borrow_book.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IBookService bookService;
    @Autowired
    IUserService userService;
    @GetMapping
    public String findAllUser(Model model){
        model.addAttribute("listUser", userService.findAllUser());
        return "list_user";

    }

}
