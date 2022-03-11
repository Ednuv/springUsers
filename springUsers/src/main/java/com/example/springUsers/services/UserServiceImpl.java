package com.example.springUsers.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springUsers.dao.RolesDao;
import com.example.springUsers.dao.UsersDao;
import com.example.springUsers.entities.User;
import com.example.springUsers.entities.UserRole;

@Service
public class UserServiceImpl implements UsersService {
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private RolesDao rolesDao;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		User local = this.usersDao.findByUsername(user.getUsername());
		if(local != null) {
			System.out.println("User already exist");
			throw new Exception("User already exist");
		}else {
			for(UserRole ur: userRoles) {
				rolesDao.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local =this.usersDao.save(user);
		}
		return local;
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return usersDao.findAll();
	}

	@Override
	public User getUserbyName(String username) {
		// TODO Auto-generated method stub
		return this.usersDao.findByUsername(username);
	}

}
