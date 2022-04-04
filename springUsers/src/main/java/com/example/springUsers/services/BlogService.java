package com.example.springUsers.services;

import java.util.List;
import java.util.Set;

import com.example.springUsers.entities.blog.Blog;

public interface BlogService {
	
	public Blog addBlog(Blog blog);
	
	public Blog updateBlog(Blog blog);
	
	public void deleteBlog(Long blogId);
	
	public Set<Blog> getBlogs();
	
	public Blog getBlog(Long blogId);
	

}
