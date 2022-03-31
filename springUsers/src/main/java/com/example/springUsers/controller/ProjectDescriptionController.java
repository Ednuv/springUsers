package com.example.springUsers.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springUsers.entities.User;
import com.example.springUsers.entities.project.ProjectCategory;
import com.example.springUsers.entities.project.ProjectDescription;
import com.example.springUsers.entities.quiz.Category;
import com.example.springUsers.entities.quiz.Quiz;
import com.example.springUsers.services.ProjectDescriptionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/projectdescription")
@CrossOrigin("*")
public class ProjectDescriptionController {
	
	@Autowired
	private ProjectDescriptionService projectDescriptionService;
	
	@PostMapping("/")
	public ResponseEntity<ProjectDescription> addProjectDescription(@RequestParam("file")MultipartFile file,@RequestParam("projectdescription") String projectdescription) throws IOException{
		ProjectDescription projectDescription1 = new ObjectMapper().readValue(projectdescription, ProjectDescription.class);
		projectDescription1.setProjectpic(file.getBytes());
		projectDescription1.setProjectpicname(file.getOriginalFilename());
		ProjectDescription projectDescription2= this.projectDescriptionService.addProjectDescription(projectDescription1);
		return ResponseEntity.ok(projectDescription2);
	}
	
	@GetMapping("/{pdId}")
	public ProjectDescription getProjectDescription(@PathVariable("pdId") Long pdId) {
		
	   return this.projectDescriptionService.getProjectDescription(pdId);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getProjectDescriptions(){
		return ResponseEntity.ok(this.projectDescriptionService.getProjectDescriptions());
	}
	
	@GetMapping("/projectcategory/{cid}")
	public List<ProjectDescription> getQuizzesOfCategory(@PathVariable("cid") Long cid){
		ProjectCategory category = new ProjectCategory();
		category.setCid(cid);
		return this.projectDescriptionService.getProjectOfCategory(category);
	}

}
