package com.comarch.szkolenia.book.store.database.impl.hibernate;

import com.comarch.szkolenia.book.store.database.IOrderRepository;
import com.comarch.szkolenia.book.store.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO implements IOrderRepository {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void persist(Order order) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(order);
        tx.commit();
        session.close();
    }

    @Override
    public Order getOrderById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Order> query = session
                .createQuery("FROM com.comarch.szkolenia.book.store.model.Order " +
                        "WHERE id = :id", Order.class);
        query.setParameter("id", id);
        Order order = query.getSingleResult();
        //session.close();
        return order;
    }
}
