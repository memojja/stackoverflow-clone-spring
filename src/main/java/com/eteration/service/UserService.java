package com.eteration.service;

import com.eteration.model.User;
import com.eteration.model.Vote;

/**
 * Created by memojja on 11/07/2017.
 */
public interface UserService {

    void save(User user);

    public User findByUsername(String username);
}
