package com.comarch.szkolenia.book.store.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private User user;
    private List<Book> books = new ArrayList<>();

    public Order(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> book) {
        this.books = book;
    }
}
