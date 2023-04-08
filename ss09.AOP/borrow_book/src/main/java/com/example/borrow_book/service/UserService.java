package com.example.borrow_book.service;

import com.example.borrow_book.model.Book;
import com.example.borrow_book.model.User;
import com.example.borrow_book.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findByIdUser(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
      userRepository.deleteById(id);
    }
}
