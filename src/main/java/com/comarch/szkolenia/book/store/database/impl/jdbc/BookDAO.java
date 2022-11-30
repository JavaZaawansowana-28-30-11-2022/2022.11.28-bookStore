package com.comarch.szkolenia.book.store.database.impl.jdbc;

import com.comarch.szkolenia.book.store.database.IBookRepository;
import com.comarch.szkolenia.book.store.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IBookRepository {

    @Autowired
    Connection connection;

    @Override
    public List<Book> getBooks() {
        List<Book> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbook";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getString("isbn")
                ));
            }
        } catch (SQLException e) {
            return result;
        }

        return result;
    }
}
