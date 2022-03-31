package com.example.springUsers.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role")
public class Role {

	@Id
	private Long id;
	private String roleName;
	
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="role")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<UserRole> userRoles = new HashSet<>();
	
	public Role() {
		
	}
	
	public Role(Long id, String roleName, Set<UserRole> userRoles) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.userRoles = userRoles;
	}

	
	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
}
