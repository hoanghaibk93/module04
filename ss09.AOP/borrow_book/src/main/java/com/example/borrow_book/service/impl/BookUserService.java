package com.example.borrow_book.service.impl;

import com.example.borrow_book.model.BookUser;
import com.example.borrow_book.repository.IBookRepository;
import com.example.borrow_book.repository.IBookUserRepository;
import com.example.borrow_book.service.IBookService;
import com.example.borrow_book.service.IBookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookUserService implements IBookUserService {
    @Autowired
    private IBookUserRepository bookUserRepository;
    @Autowired
    private IBookService bookService;

    @Override
    public List<BookUser> findAllBookUser() {
        return bookUserRepository.findAll();
    }

    @Override
    public BookUser findByIdBookUser(Integer id) {
        return bookUserRepository.findById(id).get();
    }

    @Override
    public void saveBookUser(BookUser bookUser) {
        bookUserRepository.save(bookUser);
    }

    @Override
    public boolean deleteBookUser(Integer idBookUser) {
        for (BookUser bookUser : findAllBookUser()) {
            if (bookUser.getIdBorrowBook().equals(idBookUser)) {
                bookUserRepository.delete(bookUser);
                bookUser.getBook().setQuantity(bookUser.getBook().getQuantity() + 1);
                bookService.saveBook(bookUser.getBook());
                return true;
            }
        }
        return false;
    }

    @Override
    public void borrowBook(Integer idBook, Integer idUser) {
        Integer quantity = bookService.findByIdBook(idBook).getQuantity();
        bookService.findByIdBook(idBook).setQuantity(quantity - 1);
    }

}
