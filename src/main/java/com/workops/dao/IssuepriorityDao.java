package com.workops.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Issuepriority;

public interface IssuepriorityDao extends JpaRepository<Issuepriority,String> {
Optional<Issuepriority>findByName(String name);
}
