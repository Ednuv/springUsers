package com.example.springUsers.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.springUsers.entities.User;


public interface UsersDao extends JpaRepository<User,Long>{

	public User findByUsername(String username);
}
