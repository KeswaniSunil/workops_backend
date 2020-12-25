package com.workops.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workops.model.Componentissue;
import com.workops.model.ComponentissuePK;
import com.workops.model.Issue;
import com.workops.model.ProjectteamPK;


public interface ComponentissueDao extends JpaRepository <Componentissue,ComponentissuePK> {

	Optional<Componentissue> getComponentissueById(ComponentissuePK id);
	
	@Transactional
	@Modifying
	@Query(value="SELECT issueid from componentissue ci where ci.componentid=:comp",nativeQuery=true)
	List<String> getissueids(@Param("comp") String comp);
//	@Transactional
//	@Modifying
//	@Query(value="SELECT * from issue i where i.id in :issueid",nativeQuery=true)
//	List<Object> getIssues(@Param("issueid") List<String> issues);
	@Transactional
	@Modifying
	void deleteById(ComponentissuePK id);
}
