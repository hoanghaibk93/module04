package com.example.borrow_book.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_book")
    private Integer idBook;
    @Column(name ="name_book")
    private String nameBook;
    @Column(name="quantity")
    private Integer quantity;
    @ManyToMany
    @JoinTable(name="book_user", joinColumns = @JoinColumn(name ="id_book"), inverseJoinColumns = @JoinColumn(name="id_user"))
    private List<User> userList;

    public Book() {
    }

    public Book(Integer idBook, String nameBook, Integer quantity) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.quantity = quantity;
    }

    public Book(Integer idBook, String nameBook, Integer quantity, List<User> userList) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.quantity = quantity;
        this.userList = userList;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
