package com.example.borrow_book.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "name_user")
    private String nameUser;
    @ManyToMany(mappedBy = "userList")
    private List<Book> bookList;

    public User() {
    }

    public User(Integer idUser, String nameUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
    }

    public User(Integer idUser, String nameUser, List<Book> bookList) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.bookList = bookList;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
