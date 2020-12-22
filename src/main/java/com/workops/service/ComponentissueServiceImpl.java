package com.workops.service;

import java.util.ArrayList;
import java.util.List;

import com.workops.dao.ComponentissueDao;
import com.workops.dao.IssueDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Componentissue;
import com.workops.model.ComponentissuePK;
import com.workops.model.Issue;
import com.workops.model.Project;
import com.workops.model.ProjectteamPK;
import com.workops.pojo.IssueData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ComponentissueServiceImpl implements ComponentissueService{

	@Autowired
	ComponentissueDao compdao;
	@Autowired
	IssueDao idao;
	@Override
	public Componentissue createComponentIssue(Componentissue comp) throws Exception {
		return compdao.save(comp);
	}

	@Override
	public void deleteComponentissueByComponentIdAndIssueId(String componentId, String issueId) throws Exception {
		try
		{
//			System.out.println("up= "+updao.findByEmail(email).get().getFullName());

			compdao.deleteById(new ComponentissuePK(idao.findById(issueId).get(),componentId));
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	

	@Override
	public List<String> getAllIssueIds(String componentId) throws Exception {
		try
		{
		List<String> issues=compdao.getissueids(componentId);
		return issues;
		}
		catch(Exception e)
		{
			throw new ErrorDetails("Error in findings of Issues By Id.Try again Later");
		}
	}

	@Override
	public List<Issue> getAllIssuesByComponentId(List<String> issueids) throws Exception {
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
