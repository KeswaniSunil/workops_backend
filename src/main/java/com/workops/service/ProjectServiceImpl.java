package com.workops.service;

import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.ProjectDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Project;
import com.workops.pojo.ProjectData;
import com.workops.pojo.SwitchProject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
	public Optional<Project> getProjectById(String projectid) throws ErrorDetails {
		try
		{
		Optional<Project> p=projectdao.findById(projectid);
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
	public Project createProject(ProjectData project) throws ErrorDetails {
		try
		{
		Optional<Project> p=projectdao.findByName(project.getName());
		if(!p.isPresent())
		{
//			project.setId(UUID.randomUUID().toString().substring(0, 32));
			Project p1=new Project();
			p1.setId(UUID.randomUUID().toString().substring(0, 32));
			p1.setName(project.getName());
			p1.setProjectkey(project.getProjectKey());
			p1.setSelected(project.getSelected());
			return projectdao.save(p1);
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
	public void deleteProjectById(String projectid) throws ErrorDetails {
		try
		{
		Optional<Project> p=projectdao.findById(projectid);
		if(!p.isPresent())
		{

			throw new ErrorDetails("No Project Exists With this Id");
		}
		projectdao.deleteById(projectid);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
		
	}
}
