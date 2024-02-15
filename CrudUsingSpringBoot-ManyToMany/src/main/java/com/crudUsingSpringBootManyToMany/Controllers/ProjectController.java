package com.crudUsingSpringBootManyToMany.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudUsingSpringBootManyToMany.Entity.Project;
import com.crudUsingSpringBootManyToMany.Services.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/save")
	public ResponseEntity createProject (@RequestBody Project project){
		projectService.saveProject(project);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@GetMapping(value= {"/getProjects","/{projectId}"})
	public List<Project> getEmployee(@PathVariable (required = false)Long projectId){
		return projectService.getProjectDetails(projectId);
	}
	
	@DeleteMapping("delete/{projectId}")
	public ResponseEntity removeEmployee(@PathVariable Long projectId) {
		projectService.deleteProject(projectId);
		return new ResponseEntity(HttpStatus.OK);
	}
}
