package com.workops.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workops.dao.IssueattachmentDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Issueattachment;


@Service
@Transactional
public class IssueattachmentServiceImpl  implements IssueattachmentService{

	@Autowired
	IssueattachmentDao idao;
	@Override
	public List<Issueattachment> getAllIssueattachments() {
		return idao.findAll();
	}

	@Override
	public Optional<Issueattachment> getIssueAttachmentById(String issueattachmentId) throws Exception {
		try
		{
		Optional<Issueattachment> iattach=idao.findById(issueattachmentId);
		if(!iattach.isPresent())
		{
			throw  new ErrorDetails("Not Found issueattachment With Given Id");
		}
		return iattach;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Issueattachment createIssueAttachment(Issueattachment issueattachment) throws Exception {
		try
		{
		Optional<Issueattachment> iattach=idao.findByName(issueattachment.getName());
		if(!iattach.isPresent())
		{
			issueattachment.setId(UUID.randomUUID().toString().substring(0,32));
			return idao.save(issueattachment);
		}
		throw new ErrorDetails("issueattachment Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails("Error in Creating IssueAttachment or Might Already Exists");
		}
	}

	@Override
	public Issueattachment updateIssueattachment(Issueattachment issueattachment) {
		return idao.save(issueattachment);
	}

	@Override
	public void deleteIssueAttachmentById(String issueattachmentid) throws Exception {
		try
		{
		Optional<Issueattachment> com=idao.findById(issueattachmentid);
		if(!com.isPresent())
		{

			throw new ErrorDetails("No Project Exists With this Id");
		}
		idao.deleteById(issueattachmentid);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

}
