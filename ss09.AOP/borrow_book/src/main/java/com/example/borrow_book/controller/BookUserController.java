package com.example.borrow_book.controller;

import com.example.borrow_book.service.IBookService;
import com.example.borrow_book.service.IBookUserService;
import com.example.borrow_book.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/information")
public class BookUserController {
    @Autowired
    IBookService bookService;
    @Autowired
    IUserService userService;
    @Autowired
    IBookUserService bookUserService;

    @GetMapping
    public String findAllBookUser(Model model) {
        model.addAttribute("listBookUser", bookUserService.findAllBookUser());
        return "list_book_user";
    }

    @GetMapping("/{idBook}/{idUser}")
    public String borrowBook(@PathVariable Integer idBook, @PathVariable Integer idUser) {
        Integer quantity = bookService.findByIdBook(idBook).getQuantity();
        if (quantity <= 0){
            return "error-404";
        } else {
            bookUserService.borrowBook(idBook, idUser);
            bookService.saveBook(bookService.findByIdBook(idBook));
            return "redirect:/information";
        }
    }
}
