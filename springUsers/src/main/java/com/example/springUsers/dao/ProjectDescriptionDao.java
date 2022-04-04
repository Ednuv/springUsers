package com.example.springUsers.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springUsers.entities.project.ProjectCategory;
import com.example.springUsers.entities.project.ProjectDescription;


public interface ProjectDescriptionDao extends JpaRepository<ProjectDescription,Long>{
	
	 public List<ProjectDescription> findBycategory(ProjectCategory category);
	 

}
