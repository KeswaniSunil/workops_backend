package com.workops.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workops.model.Issue;

public interface IssueDao extends JpaRepository <Issue,String>{

	Optional<Issue> findByName(String name);
	@Transactional
	@Modifying
	@Query(value="SELECT count(*) from issue where sprintid is not null",nativeQuery=true)
	Integer countBySprint(String projectId);
	@Transactional
	@Modifying
	@Query(value="SELECT count(*) from issue where sprintid is null",nativeQuery=true)
	Integer countByBacklog(String projectId);
	@Query(value="SELECT * from issue i where i.sprintid is null",nativeQuery=true)
	List<Issue> findAllIssues();

	@Transactional
	@Modifying
	@Query(value="SELECT * from issue i where i.sprintid=:sid",nativeQuery=true)
	List<Issue>findAllIssuesBySprintId(@Param("sid") String sid);
}
