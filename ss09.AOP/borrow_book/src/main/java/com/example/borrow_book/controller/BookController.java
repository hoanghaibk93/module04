package com.example.borrow_book.controller;

import com.example.borrow_book.model.BookUser;
import com.example.borrow_book.service.IBookService;
import com.example.borrow_book.service.IBookUserService;
import com.example.borrow_book.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IBookUserService bookUserService;

    @GetMapping
    public String findAllBook(Model model) {
        model.addAttribute("listBook", bookService.findAllBook());
        return "list_book";

    }

    @PostMapping("/create")
    public String borrowBook(BookUser bookUser) {
        bookUserService.borrowBook(bookUser.getBook().getIdBook(), bookUser.getUser().getIdUser());
        bookUserService.saveBookUser(bookUser);
        return "redirect:/information";
    }

    @GetMapping("/{idBook}")
    public String create(@PathVariable Integer idBook, Model model) {
        Integer quantity = bookService.findByIdBook(idBook).getQuantity();
        if (quantity <= 0) {
            model.addAttribute("message", "Book is over");
            return "error-404";
        } else {
            model.addAttribute("books", bookService.findByIdBook(idBook));
            model.addAttribute("userList", userService.findAllUser());
            model.addAttribute("bookUser", new BookUser(bookService.findByIdBook(idBook)));
            return "create";
        }
    }

}
