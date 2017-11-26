package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.repository.UserRepository;
import ua.service.UserService;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    //26.11.2017 add UserDetailsServiceImpl Java Spring


    @Autowired
    private UserService userService;

    //26.11.2017 пізніше
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userService.findByEmail(s);
    }



}

