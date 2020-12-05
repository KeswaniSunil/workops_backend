package com.workops.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Project;

public interface ProjectDao  extends JpaRepository <Project,String>{

	Optional<Project> findByName(String Name);
}
