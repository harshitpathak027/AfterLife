package com.example.AfterLife.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.AfterLife.config.JwtService;
import com.example.AfterLife.model.User;
import com.example.AfterLife.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationProvider authenticationProvider;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

  public User saveUser(User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepo.save(user);
  }

  public String loginUser(User user) {
   Authentication auth = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));  
   if(auth.isAuthenticated()){
    return jwtService.generateToken(user, auth.getName());
   }
   return "Login failed";
  }
}
