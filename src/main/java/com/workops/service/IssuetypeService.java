package com.workops.service;

import java.util.List;
import java.util.Optional;

import com.workops.model.Issuetype;

public interface IssuetypeService {


	List<Issuetype> getAllIssuetypes();
	Optional<Issuetype> getIssuetypeById(String Issuetypeid)throws Exception;
	Issuetype createIssuetype(Issuetype issuetype) throws Exception;
	Issuetype updateIssuetype(Issuetype issuetype) ;
	void deleteIssuetypeById(String issuetypeid) throws Exception;
}
