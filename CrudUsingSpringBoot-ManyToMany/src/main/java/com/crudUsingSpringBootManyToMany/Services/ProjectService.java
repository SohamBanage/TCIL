package com.crudUsingSpringBootManyToMany.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudUsingSpringBootManyToMany.Entity.Project;
import com.crudUsingSpringBootManyToMany.Repository.ProjectReository;

@Service
public class ProjectService {

	@Autowired
	private ProjectReository projectReository;
	
	public void saveProject(Project project) {
		projectReository.save(project);
	}
	
	public List<Project> getProjectDetails(Long projectId){
		if(null != projectId) {
			return projectReository.findAllByProjectId(projectId);
		}else {
			return projectReository.findAll();
		}
	}
	
	public void  deleteProject (Long projectId) {
		projectReository.deleteById(projectId);
	}
}
