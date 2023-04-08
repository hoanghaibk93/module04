package com.example.borrow_book.service;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUser();

    User findByIdUser(Integer id);

    void saveUser(User user);

    void deleteUser(Integer id);
}
