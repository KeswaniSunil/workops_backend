package com.workops.service;

import java.util.List;
import java.util.Optional;

import com.workops.model.Issuestatus;

public interface IssuestatusService {


	List<Issuestatus> getAllIssueStatus();
	Optional<Issuestatus> getIssueStatusById(String Issuestatusid)throws Exception;
	Issuestatus createIssueStatus(Issuestatus issuestatus) throws Exception;
	Issuestatus updateIssueStatus(Issuestatus issuestatus) ;
	void deleteIssueStatusById(String issuestatusid) throws Exception;
}
