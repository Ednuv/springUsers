package com.example.springUsers.services.QuizImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springUsers.dao.BlogDao;
import com.example.springUsers.entities.blog.Blog;
import com.example.springUsers.services.BlogService;

@Service
public class BlogServiceImpl implements BlogService{
	
	@Autowired
	private  BlogDao blogDao;
	
	@Override
	public Blog addBlog(Blog blog) {
		// TODO Auto-generated method stub
		return this.blogDao.save(blog);
	}

	@Override
	public Blog updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return this.blogDao.save(blog);
	}

	@Override
	public void deleteBlog(Long blogId) {
		// TODO Auto-generated method stub
		Blog blog = new Blog();
		blog.setbId(blogId);
		this.blogDao.delete(blog);
	}

	@Override
	public Set<Blog> getBlogs() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.blogDao.findAll());
	}

	@Override
	public Blog getBlog(Long blogId) {
		// TODO Auto-generated method stub
		return this.blogDao.findById(blogId).get();
	}

}
