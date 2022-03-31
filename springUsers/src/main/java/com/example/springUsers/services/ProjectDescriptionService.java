package com.example.springUsers.services;

import java.util.List;
import java.util.Set;

import com.example.springUsers.entities.project.ProjectCategory;
import com.example.springUsers.entities.project.ProjectDescription;
import com.example.springUsers.entities.quiz.Category;
import com.example.springUsers.entities.quiz.Quiz;

public interface ProjectDescriptionService {

    public ProjectDescription addProjectDescription(ProjectDescription projectdescription);
	
	public ProjectDescription updateProjectDescription(ProjectDescription projectdescription);
	
	public Set<ProjectDescription> getProjectDescriptions();
	
	public ProjectDescription getProjectDescription(Long projectdescriptionId);
	
	public void deleteProjectDescription(Long projectdescriptionId);
	
	public List<ProjectDescription> getProjectOfCategory(ProjectCategory category);
}
