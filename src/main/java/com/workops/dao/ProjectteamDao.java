package com.workops.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.workops.model.Projectteam;
import com.workops.model.ProjectteamPK;

@Transactional
public interface ProjectteamDao extends JpaRepository <Projectteam,ProjectteamPK> {

	Optional<Projectteam> getProjectteamById(ProjectteamPK id); 
	@Query(
			  value = "SELECT * FROM projectteam p WHERE p.projectid = :projectid", 
			  nativeQuery = true)
	@Transactional
	List<Projectteam> getProjectteamByProjectId(@Param("projectid") String projectid);
//	
	@Transactional
	@Modifying
    @Query(value = "DELETE FROM projectteam p where p.projectid=c05d8983-33c3-11eb-acc4-588a5a24 ", nativeQuery = true)
	void deleteProject(@Param("projectid") String projectid);
	
	@Transactional
	@Modifying
	void deleteById(ProjectteamPK id);
	
	@Transactional
	@Modifying
	@Query(value="SELECT count(*) from projectteam where projectid=:projectId",nativeQuery=true)
	Integer countByProjectId(String projectId);
	
}
