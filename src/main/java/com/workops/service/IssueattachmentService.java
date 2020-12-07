package com.workops.service;

import java.util.List;
import java.util.Optional;

import com.workops.model.Issueattachment;


public interface IssueattachmentService {


	List<Issueattachment> getAllIssueattachments();
	Optional<Issueattachment> getIssueAttachmentById(String issueattachmentId)throws Exception;
	Issueattachment createIssueAttachment(Issueattachment issueattachment) throws Exception;
	Issueattachment updateIssueattachment(Issueattachment issueattachment) ;
	void deleteIssueAttachmentById(String issueattachmenttid) throws Exception;
}
