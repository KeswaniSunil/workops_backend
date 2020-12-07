package com.workops.service;

import java.util.List;
import java.util.Optional;

import com.workops.model.Issuepriority;

public interface IssuepriorityService {


	List<Issuepriority> getAllIssueprioritys();
	Optional<Issuepriority> getIssuepriorityById(String Issuepriorityid)throws Exception;
	Issuepriority createIssuepriority(Issuepriority issuepriority) throws Exception;
	Issuepriority updateIssuepriority(Issuepriority issuepriority) ;
	void deleteIssuepriorityById(String issuepriorityid) throws Exception;
}
