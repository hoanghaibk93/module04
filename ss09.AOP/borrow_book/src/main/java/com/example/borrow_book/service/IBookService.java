package com.example.borrow_book.service;

import com.example.borrow_book.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IBookService {
    List<Book> findAllBook();

    Book findByIdBook(Integer id);

    void saveBook(Book book);

    void deleteBook(Integer id);

    void borrowBook(Integer idBook);
}
