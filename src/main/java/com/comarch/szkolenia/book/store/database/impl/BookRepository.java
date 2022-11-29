package com.comarch.szkolenia.book.store.database.impl;

import com.comarch.szkolenia.book.store.database.IBookRepository;
import com.comarch.szkolenia.book.store.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        this.books.add(new Book("autor 1", "tytul 1",
                30.0, "2354-234-233-333-2"));
        this.books.add(new Book("autor 2", "tytul 2",
                30.0, "2354-234-546-333-2"));
        this.books.add(new Book("autor 3", "tytul 3",
                30.0, "2354-234-2345-345-2"));
        this.books.add(new Book("autor 4", "tytul 4",
                30.0, "55-234-233-453-2"));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }
}
