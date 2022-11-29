package com.comarch.szkolenia.book.store.services.impl;

import com.comarch.szkolenia.book.store.database.IBookRepository;
import com.comarch.szkolenia.book.store.model.Book;
import com.comarch.szkolenia.book.store.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return this.bookRepository.getBooks();
    }
}
