package com.example.springUsers.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springUsers.entities.Courses;
import com.example.springUsers.entities.Role;
import com.example.springUsers.entities.User;
import com.example.springUsers.entities.UserRole;
import com.example.springUsers.services.UsersService;

@RestController
@CrossOrigin(origins ="*", exposedHeaders = "**")
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	//@GetMapping("/users")
//	public User getUser(){
		
//		return this.usersService.createUser(null, null);
//	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		Set<UserRole> roles= new HashSet<>();
		
		Role role = new Role(null, null, null);
		role.setId(45L);
		role.setRoleName("Normal");
		
		UserRole userRole = new UserRole(null, user, role);
		
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		try {
			return this.usersService.createUser(user, roles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	@GetMapping("/users")
	public List<User> getUser(){
		
		return this.usersService.getUser();
	}
	
	@GetMapping("/users/{username}")
	public User getUserbyName(@PathVariable("username") String username) {
		
		return this.usersService.getUserbyName(username); 
	}
	

}
