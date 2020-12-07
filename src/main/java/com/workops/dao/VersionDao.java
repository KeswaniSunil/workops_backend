package com.workops.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Project;
import com.workops.model.Version;

public interface VersionDao  extends JpaRepository <Version,String> {

	Optional<Version> findByName(String Name);
	
	@Transactional
	@Modifying
	List<Version> findByProject(Project project);
}
