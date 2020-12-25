package com.workops.service;

import java.util.List;
import com.workops.model.Issue;
import com.workops.model.Issueversion;

public interface IssueversionService {

	Issueversion createIssueVersion(Issueversion v) throws Exception;
	void deleteIssueversionByVersionIdAndIssueId(String versionId,String issueId) throws Exception;
	List<Issue> getAllIssuesByVersionId(List<String> ids) throws Exception;
	List<String> getAllIssueIds(String versionId) throws Exception;
	
}
