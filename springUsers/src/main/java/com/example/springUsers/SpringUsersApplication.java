package com.example.springUsers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.example.springUsers.entities.Role;
import com.example.springUsers.entities.User;
import com.example.springUsers.entities.UserRole;
import com.example.springUsers.services.UsersService;

@SpringBootApplication
public class SpringUsersApplication implements CommandLineRunner {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringUsersApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
	/*	user.setFirstName("Pratik");
		user.setLastName("Raj");
		user.setUsername("praj299@gmail.com");
		user.setPassword(this.bCryptPasswordEncoder.encode("Patty@50107"));
		user.setEmail("praj299@gmail.com");
		Role role1 = new Role();
		role1.setId(13L);
		role1.setRoleName("Admin");
		
		Set<UserRole> userRoleSet= new HashSet<>();
		UserRole userRole= new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		User user1 = this.userService.createUser(user, userRoleSet); */
		
		
	}
	

	/*public void addViewController(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}*/
	
	

}
