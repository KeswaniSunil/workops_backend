package com.workops.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.IssueDao;
import com.workops.dao.IssueversionDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Issue;
import com.workops.model.Issueversion;
import com.workops.model.IssueversionPK;

@Service
@Transactional
public class IssueversionServiceImpl implements IssueversionService {

	@Autowired
	IssueversionDao ivdao;
	@Autowired
	IssueDao idao;
	
	@Override
	public Issueversion createIssueVersion(Issueversion v) throws Exception {
		return ivdao.save(v);
	}
	
	@Override
	public void deleteIssueversionByVersionIdAndIssueId(String versionId, String issueId) throws Exception {
		try
		{
			ivdao.deleteById(new IssueversionPK(idao.findById(issueId).get(),versionId));
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}
	
	@Override
	public List<String> getAllIssueIds(String versionId) throws Exception {
		try
		{
		List<String> issues=ivdao.getissueids(versionId);
		return issues;
		}
		catch(Exception e)
		{
			throw new ErrorDetails("Error in findings of Issues, Try again Later");
		}
	}
	
	@Override
	public List<Issue> getAllIssuesByVersionId(List<String> issueids) throws Exception {
		try
		{
		List<Issue>issues=new ArrayList<>();
		for(String iss:issueids)
		{
			issues.add(idao.findById(iss).get());
		}
		return issues;
		}
		catch(Exception e)
		{
			throw new ErrorDetails("Error in findings of Issues="+e.getMessage());
		}
	}
}
