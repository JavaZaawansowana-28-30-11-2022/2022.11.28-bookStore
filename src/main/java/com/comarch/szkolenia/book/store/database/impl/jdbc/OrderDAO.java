package com.comarch.szkolenia.book.store.database.impl.jdbc;

import com.comarch.szkolenia.book.store.database.IOrderRepository;
import com.comarch.szkolenia.book.store.model.Book;
import com.comarch.szkolenia.book.store.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class OrderDAO implements IOrderRepository {
    @Autowired
    Connection connection;

    @Override
    public void persist(Order order) {
        try {
            String sql = "INSERT INTO torder (user_id) VALUES (?)";
            PreparedStatement ps = this.connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUser().getId());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            order.setId(rs.getInt(1));

            String sql2 = "INSERT INTO torder_tbook (order_id, book_id) VALUES (?, ?)";
            PreparedStatement ps2 = this.connection.prepareStatement(sql2);

            for(Book book : order.getBooks()) {
                ps2.setInt(1, order.getId());
                ps2.setInt(2, book.getId());
                ps2.executeUpdate();
                ps2.clearParameters();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
