package com.workops.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Project;

@Transactional
public interface ProjectDao  extends JpaRepository <Project,String>{

}
