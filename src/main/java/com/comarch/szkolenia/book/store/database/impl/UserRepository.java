package com.comarch.szkolenia.book.store.database.impl;

import com.comarch.szkolenia.book.store.database.IUserRepository;
import com.comarch.szkolenia.book.store.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        this.users.add(new User("admin", "admin"));
        this.users.add(new User("janusz", "janusz"));
    }

    public Optional<User> getUserByLogin(String login) {
        /*for(User user : users) {
            if(user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();*/

        return this.users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
    }
}
