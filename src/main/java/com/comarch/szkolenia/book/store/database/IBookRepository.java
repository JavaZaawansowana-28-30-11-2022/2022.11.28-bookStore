package com.comarch.szkolenia.book.store.database;

import com.comarch.szkolenia.book.store.model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> getBooks();
}
