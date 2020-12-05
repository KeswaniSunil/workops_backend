package com.workops.service;

import java.util.List;

import java.util.Optional;
import com.workops.exception.ErrorDetails;
import com.workops.model.Project;
import com.workops.pojo.ProjectData;
import com.workops.pojo.SwitchProject;

public interface ProjectService {

	List<Project> getAllProjects();
	Optional<Project> getProjectById(String projectid)throws Exception;
	Project createProject(ProjectData project) throws Exception;
	Project updateProject(Project project) ;
	void deleteProjectById(String projectid) throws Exception;
}
