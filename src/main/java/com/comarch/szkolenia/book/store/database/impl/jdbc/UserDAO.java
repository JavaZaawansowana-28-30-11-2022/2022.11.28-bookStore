package com.comarch.szkolenia.book.store.database.impl.jdbc;

import com.comarch.szkolenia.book.store.database.IUserRepository;
import com.comarch.szkolenia.book.store.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UserDAO implements IUserRepository {

    @Autowired
    Connection connection;
    @Override
    public Optional<User> getUserByLogin(String login) {
        try {
            String sql = "SELECT * FROM tuser WHERE login = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return Optional.of(new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password")
                        ));
            }
            return Optional.empty();
        } catch (SQLException e) {
            return Optional.empty();
        }
    }
}
