package com.example.borrow_book.model;

import javax.persistence.*;

@Entity
@Table(name="book_user")
public class BookUser {
    @EmbeddedId
    BookUserKey id;
    @ManyToOne
    @MapsId("id_book")
    @JoinColumn(name="id_book")
    private Book book;

    @ManyToOne
    @MapsId("id_user")
    @JoinColumn(name="id_user")
    private User user;
 private Integer IdBorrowBook;

    public BookUser() {
    }

    public BookUser(BookUserKey id, Book book, User user, Integer idBorrowBook) {
        this.id = id;
        this.book = book;
        this.user = user;
        IdBorrowBook = idBorrowBook;
    }

    public BookUserKey getId() {
        return id;
    }

    public void setId(BookUserKey id) {
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
        return IdBorrowBook;
    }

    public void setIdBorrowBook(Integer idBorrowBook) {
        IdBorrowBook = idBorrowBook;
    }
}
