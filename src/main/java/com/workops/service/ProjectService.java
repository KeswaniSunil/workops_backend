package com.workops.service;

import java.util.List;

import java.util.Optional;
import com.workops.exception.ErrorDetails;
import com.workops.model.Project;
import com.workops.pojo.SwitchProject;

public interface ProjectService {

	List<Project> getAllProjects();
	Optional<Project> getProjectById(String id)throws Exception;
	Project createProject(Project project) throws Exception;
	Project updateProject(Project project) ;
	void deleteProjectById(Project project) throws Exception;
}
