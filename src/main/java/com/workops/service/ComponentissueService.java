package com.workops.service;

import java.util.List;
import com.workops.model.Componentissue;
import com.workops.model.Issue;
import com.workops.pojo.IssueData;

public interface ComponentissueService {

	Componentissue createComponentIssue(Componentissue comp) throws Exception;
	void deleteComponentissueByComponentIdAndIssueId(String componentId,String issueId) throws Exception;
	List<Issue> getAllIssuesByComponentId(List<String> issueids) throws Exception;
	List<String> getAllIssueIds(String componentId) throws Exception; 
}
