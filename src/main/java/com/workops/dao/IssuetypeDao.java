package com.workops.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Issuetype;

public interface IssuetypeDao extends JpaRepository<Issuetype,String> {
Optional<Issuetype>findByName(String name);
}
