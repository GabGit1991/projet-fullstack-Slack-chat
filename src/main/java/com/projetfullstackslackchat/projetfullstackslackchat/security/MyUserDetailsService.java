package com.projetfullstackslackchat.projetfullstackslackchat.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetfullstackslackchat.projetfullstackslackchat.entity.User;
import com.projetfullstackslackchat.projetfullstackslackchat.service.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userService.findByUsername(username).isPresent() == false) {
            throw new UsernameNotFoundException(username + " introuvable dans la base de donnée");
        }
        User user = userService.findByUsername(username).get();
        List<GrantedAuthority> auths = new ArrayList<>();
        user.getRoles().forEach(role -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
            auths.add(authority);
        });
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), auths);
    }

}
