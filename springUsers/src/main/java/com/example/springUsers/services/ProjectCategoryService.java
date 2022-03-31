package com.example.springUsers.services;

import java.util.Set;

import com.example.springUsers.entities.project.ProjectCategory;
import com.example.springUsers.entities.quiz.Category;

public interface ProjectCategoryService {
	
    public ProjectCategory addProjectCategory(ProjectCategory category);
	
	public ProjectCategory updateProjectCategory(ProjectCategory category);
	
	public Set<ProjectCategory> getProjectCategories();
	
	public ProjectCategory getprojectcategory(Long categoryId);
	
	public void deleteProjectCategory(Long categoryId);

}
