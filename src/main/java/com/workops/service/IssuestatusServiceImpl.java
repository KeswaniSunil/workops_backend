package com.workops.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.IssuestatusDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Issuestatus;

@Service
@Transactional
public class IssuestatusServiceImpl implements IssuestatusService {

	@Autowired
	IssuestatusDao istdao;
	@Override
	public List<Issuestatus> getAllIssueStatus() {
		return istdao.findAll();
	}

	@Override
	public Optional<Issuestatus> getIssueStatusById(String Issuestatusid) throws Exception {
		try
		{
		Optional<Issuestatus> issue=istdao.findById(Issuestatusid);
		if(!issue.isPresent())
		{
			throw  new ErrorDetails("Not Found Issuestatus With Given Id");
		}
		return issue;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Issuestatus createIssueStatus(Issuestatus issuestatus) throws Exception {
		try {
		Optional<Issuestatus> issue=istdao.findByName(issuestatus.getName());
		if(!issue.isPresent())
		{
			issuestatus.setId(UUID.randomUUID().toString().substring(0,32));
			return istdao.save(issuestatus);
		}
		throw new ErrorDetails("Issuestatus Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Issuestatus updateIssueStatus(Issuestatus issuestatus) {
		return istdao.save(issuestatus);
	}

	@Override
	public void deleteIssueStatusById(String issuestatusid) throws Exception {
		try
		{
		Optional<Issuestatus> issue=istdao.findById(issuestatusid);
		if(!issue.isPresent())
		{

			throw new ErrorDetails("No Issuestatus Exists With this Id");
		}
		istdao.deleteById(issuestatusid);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
		
	}

}
