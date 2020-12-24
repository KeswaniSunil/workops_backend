package com.workops.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.workops.model.Project;

@Transactional
public interface ProjectDao  extends JpaRepository <Project,String>{

	Optional<Project> findByName(String Name);
	@Transactional
	@Modifying
	@Query(value="SELECT projectid from projectteam pt where pt.email=:email",nativeQuery=true)
	List<String> getprojectids(@Param("email") String email);
	@Transactional
	@Modifying
	@Query(value="SELECT * from project p where p.id in :projs",nativeQuery=true)
	List<Project> getprojects(@Param("projs") List<String> projs);
}
