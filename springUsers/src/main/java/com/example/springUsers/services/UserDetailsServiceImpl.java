package com.example.springUsers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springUsers.dao.UsersDao;
import com.example.springUsers.entities.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsersDao usersDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = this.usersDao.findByUsername(username);
		System.out.print(user);
		if(user == null) {
			System.out.println();
			throw new UsernameNotFoundException("User not found");
		}
		
		return user;
	}

}
