package com.comarch.szkolenia.book.store.database.impl;

import com.comarch.szkolenia.book.store.database.IUserRepository;
import com.comarch.szkolenia.book.store.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public class UserRepository2 implements IUserRepository {
    @Override
    public Optional<User> getUserByLogin(String login) {
        return Optional.empty();
    }
}
