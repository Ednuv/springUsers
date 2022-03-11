package com.example.springUsers.services;

import java.util.List;

import com.example.springUsers.entities.Courses;

public interface CourseService {

	public List<Courses> getCourses();
	
	public Courses getCourse(long courseId);
	
	public Courses addCourse(Courses course);
}
