package com.workops.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Project;

public interface ProjectDao  extends JpaRepository <Project,String>{

}
