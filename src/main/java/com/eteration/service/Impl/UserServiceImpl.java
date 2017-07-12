package com.eteration.service.Impl;

import com.eteration.dao.UserDao;
import com.eteration.model.User;
import com.eteration.service.SecurityService;
import com.eteration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by memojja on 11/07/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
