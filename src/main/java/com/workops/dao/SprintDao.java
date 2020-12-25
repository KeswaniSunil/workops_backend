package com.workops.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workops.model.Sprint;

public interface SprintDao extends JpaRepository<Sprint, String> {
	
	Optional<Sprint> findByName(String Name);
	@Query(value = "SELECT * FROM sprint u WHERE u.projectId = ?1",nativeQuery = true)
	List<Sprint> findSprintByProjectid(String projectid);
	@Transactional
	@Modifying
	@Query(value="SELECT count(*) from sprint where projectId=:projectId",nativeQuery=true)
	Integer countByProjectId(String projectId);
}
