package com.workops.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.IssuepriorityDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Issuepriority;

@Service
@Transactional
public class IssuepriorityServiceImpl implements IssuepriorityService {


	@Autowired
	IssuepriorityDao itdao;
	@Override
	public List<Issuepriority> getAllIssueprioritys() {
		return itdao.findAll();
	}

	@Override
	public Optional<Issuepriority> getIssuepriorityById(String Issuepriorityid) throws Exception {
		try
		{
		Optional<Issuepriority> issue=itdao.findById(Issuepriorityid);
		if(!issue.isPresent())
		{
			throw  new ErrorDetails("Not Found IssuePriority With Given Id");
		}
		return issue;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Issuepriority createIssuepriority(Issuepriority issuepriority) throws Exception {
		try {
		Optional<Issuepriority> issue=itdao.findByName(issuepriority.getName());
		if(!issue.isPresent())
		{
			issuepriority.setId(UUID.randomUUID().toString().substring(0,32));
			return itdao.save(issuepriority);
		}
		throw new ErrorDetails("IssuePriority Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Issuepriority updateIssuepriority(Issuepriority issuepriority) {
		return itdao.save(issuepriority);
	}

	@Override
	public void deleteIssuepriorityById(String issuepriorityid) throws Exception {
		try
		{
		Optional<Issuepriority> issue=itdao.findById(issuepriorityid);
		if(!issue.isPresent())
		{

			throw new ErrorDetails("No IssuePriority Exists With this Id");
		}
		itdao.deleteById(issuepriorityid);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
		
	}
}
