package com.example.borrow_book.model;

import javax.persistence.*;

@Entity
@Table(name = "book_user")
public class BookUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book_user")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    private Integer idBorrowBook = (int) (Math.random() * (99999 - 10000 + 1) + 10000);

    public BookUser() {

    }

    public BookUser(Book book) {
        this.book = book;
    }

    public BookUser(Book book, User user, Integer idBorrowBook) {
        this.book = book;
        this.user = user;
        this.idBorrowBook = idBorrowBook;
    }

    public BookUser(Integer id, Book book, User user, Integer idBorrowBook) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.idBorrowBook = idBorrowBook;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getIdBorrowBook() {
        return idBorrowBook;
    }

    public void setIdBorrowBook(Integer idBorrowBook) {
        this.idBorrowBook = idBorrowBook;
    }
}
