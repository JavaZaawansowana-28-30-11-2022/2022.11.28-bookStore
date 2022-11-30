package com.comarch.szkolenia.book.store.database.impl.hibernate;

import com.comarch.szkolenia.book.store.database.IBookRepository;
import com.comarch.szkolenia.book.store.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAO implements IBookRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Book> getBooks() {
        Session session = this.sessionFactory.openSession();
        Query<Book> query = session
                .createQuery("FROM com.comarch.szkolenia.book.store.model.Book",
                        Book.class);
        List<Book> books = query.getResultList();
        session.close();
        return books;
    }
}
