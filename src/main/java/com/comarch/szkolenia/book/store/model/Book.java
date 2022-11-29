package com.comarch.szkolenia.book.store.model;

public class Book {
    private int id;
    private String author;
    private String title;
    private double price;
    private String isbn;

    public Book(int id, String author, String title, double price, String isbn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
        this.isbn = isbn;
    }

    public Book(String author, String title, double price, String isbn) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.isbn = isbn;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
