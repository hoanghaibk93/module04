package com.example.borrow_book.repository;

import com.example.borrow_book.model.BookUser;
import javafx.beans.property.adapter.JavaBeanProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookUserRepository extends JpaRepository<BookUser, Integer> {
}
