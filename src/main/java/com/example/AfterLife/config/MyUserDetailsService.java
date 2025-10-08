package com.example.AfterLife.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.AfterLife.model.User;
import com.example.AfterLife.repository.UserRepo;


@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = userRepo.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("username");
        }
        return new UserPrincipal(user);
       
    }
   
}
