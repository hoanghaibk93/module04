package com.example.borrow_book.repository;

import com.example.borrow_book.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
