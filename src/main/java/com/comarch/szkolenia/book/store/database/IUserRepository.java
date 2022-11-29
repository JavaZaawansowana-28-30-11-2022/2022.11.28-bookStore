package com.comarch.szkolenia.book.store.database;

import com.comarch.szkolenia.book.store.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> getUserByLogin(String login);
}
