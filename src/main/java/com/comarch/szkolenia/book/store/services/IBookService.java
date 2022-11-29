package com.comarch.szkolenia.book.store.services;

import com.comarch.szkolenia.book.store.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
}
