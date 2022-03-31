package com.example.springUsers.services.QuizImpl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springUsers.dao.ProjectDescriptionDao;
import com.example.springUsers.entities.project.ProjectCategory;
import com.example.springUsers.entities.project.ProjectDescription;
import com.example.springUsers.entities.quiz.Category;
import com.example.springUsers.entities.quiz.Quiz;
import com.example.springUsers.services.ProjectDescriptionService;

@Service
public class ProjectDescriptionServiceImpl implements ProjectDescriptionService {

	@Autowired
	private ProjectDescriptionDao projectDescriptionDao;
	
	@Override
	public ProjectDescription addProjectDescription(ProjectDescription projectdescription) {
		// TODO Auto-generated method stub
		return this.projectDescriptionDao.save(projectdescription);
	}

	@Override
	public ProjectDescription updateProjectDescription(ProjectDescription projectdescription) {
		// TODO Auto-generated method stub
		return this.projectDescriptionDao.save(projectdescription);
	}

	@Override
	public Set<ProjectDescription> getProjectDescriptions() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.projectDescriptionDao.findAll());
	}

	@Override
	public ProjectDescription getProjectDescription(Long projectdescriptionId) {
		// TODO Auto-generated method stub
		return this.projectDescriptionDao.findById(projectdescriptionId).get();
	}

	@Override
	public void deleteProjectDescription(Long projectdescriptionId) {
		// TODO Auto-generated method stub	
	}

	@Override
	public List<ProjectDescription> getProjectOfCategory(ProjectCategory category) {
		// TODO Auto-generated method stub
		return this.projectDescriptionDao.findBycategory(category);
	}
	
}
