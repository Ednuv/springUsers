package com.example.springUsers.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springUsers.entities.blog.Blog;

public interface BlogDao extends JpaRepository<Blog,Long>{

}
