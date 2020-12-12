package com.workops.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workops.model.Sprint;

public interface SprintDao extends JpaRepository<Sprint, String> {
	
	Optional<Sprint> findByName(String Name);
	@Query(value = "SELECT * FROM sprint u WHERE u.projectId = ?1",nativeQuery = true)
	List<Sprint> findSprintByProjectid(String projectid);
}
