package com.example.AfterLife.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.AfterLife.model.User;

public class UserPrincipal implements UserDetails {
     User user;
     
    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
       return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
    return user.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return user.getUsername();
    }
}
