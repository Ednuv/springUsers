package com.example.springUsers.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.springUsers.entities.Role;

public interface RolesDao extends JpaRepository<Role,Long>{

}
