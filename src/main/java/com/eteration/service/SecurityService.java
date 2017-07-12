package com.eteration.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Arslan on 12.7.2017.
 */
public interface SecurityService {

    public void autoLogin(String username,String password);

    public BCryptPasswordEncoder bCryptPasswordEncoder();

}
