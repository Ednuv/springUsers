package com.example.springUsers.services;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import java.util.Set;

import com.example.springUsers.entities.Courses;
import com.example.springUsers.entities.User;
import com.example.springUsers.entities.UserRole;

public interface UsersService {
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	public List<User> getUser();
	
	public User getUserbyName(String username);

}
