package com.eteration.service.Impl;

import com.eteration.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Arslan on 12.7.2017.
 */
@Service
public class SecurityServiceImpl implements SecurityService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    @Override
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails=userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
        System.out.println(token.isAuthenticated());
        Boolean auth=token.isAuthenticated();
        if (auth){
            SecurityContextHolder.getContext().setAuthentication(token);
        }
    }
}
