package com.workops.service;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workops.dao.ProjectteamDao;
import com.workops.dao.UserprofileDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Projectteam;
import com.workops.model.ProjectteamPK;
import com.workops.model.Userprofile;


@Service
@Transactional
public class ProjectteamServiceImpl implements ProjectteamService {

	
	@Autowired
	ProjectteamDao ptdao;
	
	@Autowired
	UserprofileDao updao;
	
	@Override
	public Projectteam createProjectteam(Projectteam project) throws Exception {
		try
		{
		return ptdao.save(project);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}
	@Override
	public List<Projectteam> getAllProjectteams() {
		return ptdao.findAll();
	}
	@Override
	public Optional<Projectteam> getProjectteamByEmailAndProjectId(String projectid,String email) throws Exception {
		try
		{
			
		Optional<Projectteam> p=ptdao.findById(new ProjectteamPK(updao.findByEmail(email).get(),projectid));
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
	public void deleteProjectteamByProjectId(String projectid) throws Exception {
		try
		{
//			System.out.println("ProjectId="+projectid);
			ptdao.deleteProject(projectid);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}
	@Override
	public void deleteProjectteamByEmailAndProjectId(String projectid,String email) throws Exception {
		try
		{
//			System.out.println("up= "+updao.findByEmail(email).get().getFullName());
			ptdao.deleteById(new ProjectteamPK(updao.findByEmail(email).get(),projectid));
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}
	@Override
	public List<Projectteam> getProjectteamByProjectId(String projectid) throws ErrorDetails {
		try
		{
		List<Projectteam> p=ptdao.getProjectteamByProjectId(projectid);
		if(p.size()==0)
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

	
}
