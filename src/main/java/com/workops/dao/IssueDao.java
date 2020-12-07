package com.workops.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Issue;

public interface IssueDao extends JpaRepository <Issue,String>{

	Optional<Issue> findByName(String name);
}
