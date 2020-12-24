package com.workops.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workops.model.Component;
import com.workops.model.Project;

@Repository
public interface ComponentDao extends JpaRepository <Component,String> {

	Optional<Component> findByName(String Name);
	
	@Transactional
	@Modifying
	List<Component> findByProject(Project project);
}
