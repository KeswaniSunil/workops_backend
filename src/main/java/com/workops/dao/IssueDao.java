package com.workops.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workops.model.Issue;

public interface IssueDao extends JpaRepository <Issue,String>{

	Optional<Issue> findByName(String name);
	@Transactional
	@Modifying
	@Query(value="SELECT * from issue i where i.sprintid is null",nativeQuery=true)
	List<Issue>findAllIssues();
}
