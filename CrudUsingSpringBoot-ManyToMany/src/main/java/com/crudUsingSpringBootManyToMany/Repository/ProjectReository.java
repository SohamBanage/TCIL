package com.crudUsingSpringBootManyToMany.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudUsingSpringBootManyToMany.Entity.Project;

public interface ProjectReository extends JpaRepository<Project, Long>{
	List<Project> findAllByProjectId(Long projectId);
}
