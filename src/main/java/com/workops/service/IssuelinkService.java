package com.workops.service;

import java.util.List;
import java.util.Optional;


import com.workops.model.Issuelink;
import com.workops.model.IssuelinkPK;



public interface IssuelinkService {


	Issuelink createIssuelink(Issuelink issuelink) throws Exception;
	List<Issuelink> getAllIssuelinks();
	Optional<Issuelink> getIssuelinkById(IssuelinkPK id)throws Exception;
//	Issuelink createProject(Issuelink Issuelink) throws Exception;
//	Issuelink updateProject(Issuelink Issuelink) ;
	List<Issuelink> getIssuelinkByName(String name) throws Exception;
	void deleteIssuelinkByName(String name) throws Exception;
	void deleteIssuelinkByParentIssueAndChildIssue(String pid,String cid) throws Exception;
}
