package com.example.borrow_book.service.impl;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.repository.IBookRepository;
import com.example.borrow_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByIdBook(Integer id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void borrowBook(Integer idBook) {
        Integer quantity = findByIdBook(idBook).getQuantity();
        findByIdBook(idBook).setQuantity(quantity - 1);
    }
}
