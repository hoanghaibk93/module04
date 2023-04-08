package com.example.borrow_book.service;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.model.BookUser;

import java.util.List;

public interface IBookUserService {
    List<BookUser> findAllBookUser();
    BookUser findByIdBookUser(Integer id);
    void saveBookUser(BookUser bookUser);
    boolean deleteBookUser(Integer id);
    void borrowBook(Integer idBook, Integer idUser);
//    void returnBook(Integer id);
}
