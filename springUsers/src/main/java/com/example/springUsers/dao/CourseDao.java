package com.example.springUsers.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springUsers.entities.Courses;

public interface CourseDao extends JpaRepository<Courses,Long> {

}
