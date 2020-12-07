package com.workops.service;

import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.ProjectDao;
import com.workops.dao.ProjectteamDao;
import com.workops.dao.RoleDao;
import com.workops.dao.UserprofileDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Project;
import com.workops.model.Projectteam;
import com.workops.model.ProjectteamPK;
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

	@Autowired
	ProjectteamDao projectteamDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	UserprofileDao userprofileDao ;
	
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
	public String createProject(ProjectData project) throws ErrorDetails {
		try
		{
		Optional<Project> p=projectdao.findByName(project.getName());
		if(!p.isPresent())
		{
//			System.out.println(project.getName()+" "+project.getDescription()+" "+project.getProjectKey()+" "+project.getEmail());
//			project.setId(UUID.randomUUID().toString().substring(0, 32));
			Project p1=new Project();
			p1.setId(UUID.randomUUID().toString().substring(0, 32));
			p1.setName(project.getName());
			p1.setProjectkey(project.getProjectKey());
			p1.setDescription(project.getDescription());
			projectdao.save(p1);
			
			Projectteam pt=new Projectteam();
			ProjectteamPK ptk=new ProjectteamPK();
			ptk.setUser(userprofileDao.findByEmail(project.getEmail()).get());
			ptk.setProjectId(p1.getId());
			
			pt.setId(ptk);
			pt.setRole(roleDao.findById(1).orElse(null));
			System.out.println("Inn");
			projectteamDao.save(pt);
			return "Project Added Succesfully";
		}
		throw new ErrorDetails("Project Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public String updateProject(Project project) {
		
				projectdao.save(project);
				return "Project Updated Successfully";
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
			throw new ErrorDetails("Error Deleting Project.Try again Later");
		}
		
	}
}
