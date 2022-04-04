package com.example.springUsers.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springUsers.entities.blog.Blog;
import com.example.springUsers.entities.project.ProjectDescription;
import com.example.springUsers.services.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("/")
	public ResponseEntity<?> getBlogs(){
		return ResponseEntity.ok(this.blogService.getBlogs());
	}
	
	@PostMapping("/")
	public ResponseEntity<Blog> addBlog(@RequestParam("file")MultipartFile file,@RequestParam("blog") String blog) throws IOException{
		Blog blog1 = new ObjectMapper().readValue(blog, Blog.class);
		blog1.setProjectpic(file.getBytes());
		blog1.setProjectpicname(file.getOriginalFilename());
		Blog blog2= this.blogService.addBlog(blog1);
		return ResponseEntity.ok(blog2);
	}
	
	@GetMapping("/{bId}")
	public Blog getBlog(@PathVariable("bId") Long bId) {
		
	   return this.blogService.getBlog(bId);
	}
	
	@DeleteMapping("/{bId}")
	public void deleteBlog(@PathVariable("bId") Long bId)
	{
		this.blogService.deleteBlog(bId);
	}
	

}
