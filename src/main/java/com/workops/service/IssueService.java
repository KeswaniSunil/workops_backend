package com.workops.service;

import java.util.List;
import java.util.Optional;

import com.workops.model.Issue;

public interface IssueService {


	List<Issue> getAllIssues();
	List<Issue> getAllIssuesBySprintId(String sprintid);
	Optional<Issue> getIssueById(String issueid)throws Exception;
	Issue createIssue(Issue issue) throws Exception;
	String updateIssue(Issue issue) ;
	void deleteIssueById(String Issueid) throws Exception;
}
