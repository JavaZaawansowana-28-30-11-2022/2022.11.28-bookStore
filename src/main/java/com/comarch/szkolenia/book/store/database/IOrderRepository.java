package com.comarch.szkolenia.book.store.database;

import com.comarch.szkolenia.book.store.model.Order;

import java.util.Optional;

public interface IOrderRepository {
    void persist(Order order);
    Order getOrderById(int id);
}
