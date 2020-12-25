package com.workops.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.SprintDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Sprint;
import com.workops.pojo.SprintData;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class SprintServiceImpl implements SprintService {
	
	@Autowired
	SprintDao sprintdao;
	
	@Override
	public List<Sprint> getAllSprints() {
		return sprintdao.findAll();
	}

	@Override
	public Optional<Sprint> getSprintById(String sprintid) throws Exception {
		try
		{
		Optional<Sprint> s=sprintdao.findById(sprintid);
		if(!s.isPresent())
		{
			throw  new ErrorDetails("Not Found Sprint With Given Id");
		}
		return s;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}
	@Override
	public Optional<Sprint> getSprintByName(String name) throws Exception {
		try
	{
		Optional<Sprint> s=sprintdao.findByName(name);
		if(!s.isPresent())
		{
			throw  new ErrorDetails("Not Found Sprint With Given Name");
		}
		return s;
		}
		catch(Exception e)
	{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Sprint createSprint(SprintData sprint) throws Exception {
		try
		{
		Optional<Sprint> s=sprintdao.findByName(sprint.getName());
		if(!s.isPresent())
		{
			sprint.setId(UUID.randomUUID().toString().substring(0, 32));
			Sprint s1=new Sprint();
			s1.setId(UUID.randomUUID().toString().substring(0, 32));
			s1.setName(sprint.getName());
			s1.setStartdate(sprint.getStartdate());
			s1.setEnddate(sprint.getEnddate());
			s1.setGoal(sprint.getGoal());
			s1.setSequence(sprint.getSequence());
			s1.setCompleted(sprint.getCompleted());
			s1.setProject(sprint.getProjectid());
			
			return sprintdao.save(s1);
		}
		throw new ErrorDetails("Sprint Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Sprint updateSprint(Sprint sprint) {
		return sprintdao.save(sprint);
	}

	@Override
	public void deleteSprintById(String sprintid) throws Exception {
		try
		{
		Optional<Sprint> p=sprintdao.findById(sprintid);
		if(!p.isPresent())
		{

			throw new ErrorDetails("No Sprints Exists With this Id");
		}
		sprintdao.deleteById(sprintid);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}
	
	@Override
	public List<Sprint> getSprintByProjectid(String projectid) throws Exception {
		try
		{
		List<Sprint> s=sprintdao.findSprintByProjectid(projectid);
		if(s.isEmpty())
		{
			throw  new ErrorDetails("Not Found Sprints With Given Name");
		}
		return s;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}
	
}
