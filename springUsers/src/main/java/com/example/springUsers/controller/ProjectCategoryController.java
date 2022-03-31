package com.example.springUsers.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springUsers.entities.project.ProjectCategory;
import com.example.springUsers.services.ProjectCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/projectcategory")
@CrossOrigin("*")
public class ProjectCategoryController {
	
	@Autowired
	private ProjectCategoryService projectCategoryService;
	
	@PostMapping("/")
	public ResponseEntity<ProjectCategory> addProjectCategory(@RequestBody ProjectCategory category){
		ProjectCategory category1= this.projectCategoryService.addProjectCategory(category);
		return ResponseEntity.ok(category1);
	}
	
	@GetMapping("/{categoryId}")
	public ProjectCategory getProjectCategory(@PathVariable("categoryId") Long categoryId) {
		
	   return this.projectCategoryService.getprojectcategory(categoryId);	
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getProjectCategories(){
		return ResponseEntity.ok(this.projectCategoryService.getProjectCategories());
	}
	
	@PutMapping("/")
	public ProjectCategory updateProjectCategory(@RequestBody ProjectCategory category) {
		return this.projectCategoryService.updateProjectCategory(category);
	}
	
	@DeleteMapping("/{categoryId}")
	public void deleteProjectCategory(@PathVariable("categoryId") Long categoryId)
	{
		this.projectCategoryService.deleteProjectCategory(categoryId);
	}
	
}
