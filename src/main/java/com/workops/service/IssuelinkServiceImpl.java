package com.workops.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.IssuelinkDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Issuelink;
import com.workops.model.IssuelinkPK;

@Transactional
@Service
public class IssuelinkServiceImpl implements IssuelinkService {

	@Autowired
	IssuelinkDao idao;
	@Override
	public Issuelink createIssuelink(Issuelink issuelink) throws Exception {
		try
		{
		return idao.save(issuelink);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public List<Issuelink> getAllIssuelinks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Issuelink> getIssuelinkById(IssuelinkPK id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issuelink> getIssuelinkByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteIssuelinkByName(String name) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteIssuelinkByParentIssueAndChildIssue(String pid, String cid) throws Exception {
		// TODO Auto-generated method stub

	}

}
