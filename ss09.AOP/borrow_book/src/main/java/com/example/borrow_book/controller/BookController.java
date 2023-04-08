package com.example.borrow_book.controller;

import com.example.borrow_book.service.IBookService;
import com.example.borrow_book.service.IUserService;
import com.example.borrow_book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService bookService;
    @Autowired
    IUserService userService;
    @GetMapping
    public String findAllBook(Model model){
        model.addAttribute("listBook", bookService.findAllBook());
        return "list_book";

    }
}
