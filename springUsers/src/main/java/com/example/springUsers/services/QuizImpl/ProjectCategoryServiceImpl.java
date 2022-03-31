package com.example.springUsers.services.QuizImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springUsers.dao.ProjectCategoryDao;
import com.example.springUsers.entities.project.ProjectCategory;
import com.example.springUsers.services.ProjectCategoryService;

@Service
public class ProjectCategoryServiceImpl implements ProjectCategoryService {

	@Autowired
	private ProjectCategoryDao projectCategoryDao;
	
	@Override
	public ProjectCategory addProjectCategory(ProjectCategory category) {
		// TODO Auto-generated method stub
		return this.projectCategoryDao.save(category);
	}

	@Override
	public ProjectCategory updateProjectCategory(ProjectCategory category) {
		// TODO Auto-generated method stub
		return this.projectCategoryDao.save(category);
	}

	@Override
	public Set<ProjectCategory> getProjectCategories() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.projectCategoryDao.findAll());
	}

	@Override
	public ProjectCategory getprojectcategory(Long categoryId) {
		// TODO Auto-generated method stub
		return this.projectCategoryDao.getById(categoryId);
	}

	@Override
	public void deleteProjectCategory(Long categoryId) {
		// TODO Auto-generated method stub
		
	}

}
