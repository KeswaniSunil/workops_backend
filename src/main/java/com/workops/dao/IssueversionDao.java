package com.workops.dao;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workops.model.Issueversion;
import com.workops.model.IssueversionPK;

public interface IssueversionDao extends JpaRepository<Issueversion, IssueversionPK> {
	
Optional<Issueversion> getIssueversionById(IssueversionPK id);
	
	@Transactional
	@Modifying
	@Query(value="SELECT issueid from issueversion ci where ci.versionid=:v",nativeQuery=true)
	List<String> getissueids(@Param("v") String v);
	
	@Transactional
	@Modifying
	void deleteById(IssueversionPK id);
	
}
