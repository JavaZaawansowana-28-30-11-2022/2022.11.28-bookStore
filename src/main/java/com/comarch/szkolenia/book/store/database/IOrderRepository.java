package com.comarch.szkolenia.book.store.database;

import com.comarch.szkolenia.book.store.model.Order;

public interface IOrderRepository {
    void persist(Order order);
}
