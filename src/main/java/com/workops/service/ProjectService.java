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
	String createProject(ProjectData project) throws Exception;
	String updateProject(Project project);
	void deleteProjectById(String projectid) throws Exception;
	List<Project> getAllUserProjects(List<String > projs) throws Exception;
	List<String> getProjectIds(String email) throws Exception;
}
