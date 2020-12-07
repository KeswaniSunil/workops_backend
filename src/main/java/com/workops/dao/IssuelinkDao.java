package com.workops.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Issuelink;
import com.workops.model.IssuelinkPK;

public interface IssuelinkDao extends JpaRepository <Issuelink,IssuelinkPK> {

	Optional<Issuelink> getProjectteamById(IssuelinkPK id);
	List<Issuelink> getIssueLinkByName(String name);
	@Transactional
	@Modifying
	void deleteById(IssuelinkPK id);	
}
