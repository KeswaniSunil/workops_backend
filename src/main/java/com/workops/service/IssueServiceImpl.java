package com.workops.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.IssueDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Issue;

@Service
@Transactional
public class IssueServiceImpl implements IssueService {

	@Autowired
	IssueDao idao;
	@Override
	public List<Issue> getAllIssues() {
		return idao.findAll();
	}

	@Override
	public Optional<Issue> getIssueById(String issueid) throws Exception {
		
		try
		{
		Optional<Issue> issue=idao.findById(issueid);
		if(!issue.isPresent())
		{
			throw  new ErrorDetails("Not Found Component With Given Id");
		}
		return issue;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Issue createIssue(Issue issue) throws Exception {
		try{
		Optional<Issue> issuepresent=idao.findByName(issue.getName());
		if(!issuepresent.isPresent())
		{
			issue.setId(UUID.randomUUID().toString().substring(0,32));
			return idao.save(issue);
		}
		throw new ErrorDetails("Component Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails("Error in Creating Issue");
		}
	}

	@Override
	public String updateIssue(Issue issue) {
		idao.delete(issue);
		idao.save(issue);
		return "Updated Issue";
	}

	@Override
	public void deleteIssueById(String Issueid) throws Exception {

		try
		{
		Optional<Issue> issue=idao.findById(Issueid);
		if(!issue.isPresent())
		{

			throw new ErrorDetails("No Issue Exists With this Id");
		}
		idao.deleteById(Issueid);
		}
		catch(Exception e)
		{
			throw new ErrorDetails("Error in Deleteing Issue");
		}
	}

}
