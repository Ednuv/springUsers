package com.example.springUsers.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springUsers.entities.project.ProjectCategory;

public interface ProjectCategoryDao extends JpaRepository<ProjectCategory,Long>{

}
