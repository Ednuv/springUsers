package com.example.springUsers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springUsers.dao.CourseDao;
import com.example.springUsers.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {

	}
	
	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}
	
	@Override
	public Courses getCourse(long courseId) {
		// TODO Auto-generated method stub
	  
		return courseDao.getById(courseId);
	}
	
	@Override
	public Courses addCourse(Courses course) {
		// TODO Auto-generated method stub
	    courseDao.save(course);
		return course;
	}

}
