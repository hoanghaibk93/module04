package com.example.borrow_book.controller;

import com.example.borrow_book.service.IBookService;
import com.example.borrow_book.service.IBookUserService;
import com.example.borrow_book.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/information")
public class BookUserController {
    @Autowired
    private IBookUserService bookUserService;

    @GetMapping
    public String findAllBookUser(Model model) {
        model.addAttribute("listBookUser", bookUserService.findAllBookUser());
        return "list_book_user";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Integer idBookUser, Model model) {
        if (!bookUserService.deleteBookUser(idBookUser)) {
            model.addAttribute("message", "Book code is not correct");
            return "error-404";
        } else {
            return "redirect:/information";
        }
    }
}
