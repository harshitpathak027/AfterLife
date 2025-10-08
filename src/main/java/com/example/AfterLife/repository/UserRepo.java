package com.example.AfterLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AfterLife.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{
User findByUsername(String username);
}
