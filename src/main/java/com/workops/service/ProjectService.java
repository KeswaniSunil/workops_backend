package com.workops.service;

import java.util.List;

import java.util.Optional;
import com.workops.exception.ErrorDetails;
import com.workops.model.Project;

public interface ProjectService {

	List<Project> getAllProjects();
	Optional<Project> getProjectById(Project project)throws Exception;
	Project createProject(Project project) throws Exception;
	Project updateProject(Project project) ;
	void deleteProjectById(Project project) throws Exception;
	
}
