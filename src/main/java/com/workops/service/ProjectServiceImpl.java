package com.workops.service;

import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.ProjectDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Project;
import com.workops.pojo.SwitchProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectdao;

	@Override
	public List<Project> getAllProjects() {
		return projectdao.findAll();
	}

	@Override
	public Optional<Project> getProjectById(Project project) throws ErrorDetails {
		try
		{
		Optional<Project> p=projectdao.findById(project.getId());
		if(!p.isPresent())
		{
			throw  new ErrorDetails("Not Found Project With Given Id");
		}
		return p;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}
	@Override
	public Project createProject(Project project) throws ErrorDetails {
		try
		{
		Optional<Project> p=projectdao.findById(project.getId());
		if(!p.isPresent())
		{
			return projectdao.save(project);
		}
		throw new ErrorDetails("Project Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Project updateProject(Project project) {
		return projectdao.save(project);
	}

	@Override
	public void deleteProjectById(Project project) throws ErrorDetails {
		try
		{
		Optional<Project> p=projectdao.findById(project.getId());
		if(!p.isPresent())
		{

			throw new ErrorDetails("No Project Exists With this Id");
		}
		projectdao.deleteById(project.getId());
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
		
	}
}
