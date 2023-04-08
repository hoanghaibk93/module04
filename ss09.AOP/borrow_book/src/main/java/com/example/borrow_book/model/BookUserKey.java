package com.example.borrow_book.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BookUserKey implements Serializable {
    @Column(name = "id_book")
    Integer ibBook;
    @Column(name = "id_user")
    Integer idUser;

    public BookUserKey() {
    }

    public BookUserKey(Integer ibBook, Integer idUser) {
        this.ibBook = ibBook;
        this.idUser = idUser;
    }

    public Integer getIbBook() {
        return ibBook;
    }

    public void setIbBook(Integer ibBook) {
        this.ibBook = ibBook;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
