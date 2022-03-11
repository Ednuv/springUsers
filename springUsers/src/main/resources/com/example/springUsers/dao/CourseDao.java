package com.example.springUsers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springUsers.entities.Courses;

@Repository
public interface CourseDao extends JpaRepository<Courses,Long>{

}
