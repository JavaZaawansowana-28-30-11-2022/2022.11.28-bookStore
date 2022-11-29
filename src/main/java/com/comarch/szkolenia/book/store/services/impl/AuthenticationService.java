package com.comarch.szkolenia.book.store.services.impl;

import com.comarch.szkolenia.book.store.database.IUserRepository;
import com.comarch.szkolenia.book.store.model.User;
import com.comarch.szkolenia.book.store.services.IAuthenticationService;
import com.comarch.szkolenia.book.store.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    IUserRepository userRepository;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> userFromDB = this.userRepository.getUserByLogin(login);
        if(userFromDB.isPresent() &&
                userFromDB.get().getPassword().equals(password)) {
            this.sessionObject.setUser(userFromDB.get());
        }
    }
}
