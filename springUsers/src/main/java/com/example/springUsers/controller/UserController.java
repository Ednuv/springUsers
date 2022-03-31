package com.example.springUsers.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springUsers.entities.Courses;
import com.example.springUsers.entities.Role;
import com.example.springUsers.entities.User;
import com.example.springUsers.entities.UserRole;
import com.example.springUsers.services.UsersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public User createUser(@RequestParam("file")MultipartFile file, @RequestParam("user") String user) throws IOException {
		
		User user1 = new ObjectMapper().readValue(user, User.class);
		user1.setPicByte(file.getBytes());
		user1.setProfile(file.getOriginalFilename());
		
		user1.setPassword(this.bCryptPasswordEncoder.encode(user1.getPassword()));
		Set<UserRole> roles= new HashSet<>();
	
		
		Role role = new Role(null, null, null);
		role.setId(45L);
		role.setRoleName("Normal");
		
		UserRole userRole = new UserRole(null, user1, role);
		
		userRole.setUser(user1);
		userRole.setRole(role);
		roles.add(userRole);
		try {
			return this.usersService.createUser(user1, roles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user1;
	}
	
	@GetMapping("/users/test")
	public String test() {
		return "Welcome to Backend";
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


