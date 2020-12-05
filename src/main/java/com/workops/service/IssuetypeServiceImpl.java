package com.workops.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.IssuetypeDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Issuetype;

@Service
@Transactional
public class IssuetypeServiceImpl implements IssuetypeService {

	@Autowired
	IssuetypeDao itdao;
	@Override
	public List<Issuetype> getAllIssuetypes() {
		return itdao.findAll();
	}

	@Override
	public Optional<Issuetype> getIssuetypeById(String Issuetypeid) throws Exception {
		try
		{
		Optional<Issuetype> issue=itdao.findById(Issuetypeid);
		if(!issue.isPresent())
		{
			throw  new ErrorDetails("Not Found Issuetype With Given Id");
		}
		return issue;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Issuetype createIssuetype(Issuetype issuetype) throws Exception {
		try {
		Optional<Issuetype> issue=itdao.findByName(issuetype.getName());
		if(!issue.isPresent())
		{
			issuetype.setId(UUID.randomUUID().toString().substring(0,32));
			return itdao.save(issuetype);
		}
		throw new ErrorDetails("Issuetype Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Issuetype updateIssuetype(Issuetype issuetype) {
		return itdao.save(issuetype);
	}

	@Override
	public void deleteIssuetypeById(String issuetypeid) throws Exception {
		try
		{
		Optional<Issuetype> issue=itdao.findById(issuetypeid);
		if(!issue.isPresent())
		{

			throw new ErrorDetails("No IssueType Exists With this Id");
		}
		itdao.deleteById(issuetypeid);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
		
	}

}
