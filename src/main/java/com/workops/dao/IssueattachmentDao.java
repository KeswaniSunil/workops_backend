package com.workops.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Issueattachment;

public interface IssueattachmentDao extends JpaRepository<Issueattachment,String> {

	Optional<Issueattachment> findByName(String Name);
}
