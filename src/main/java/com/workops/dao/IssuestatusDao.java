package com.workops.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Issuestatus;

public interface IssuestatusDao extends JpaRepository<Issuestatus,String> {
Optional<Issuestatus>findByName(String name);
}
