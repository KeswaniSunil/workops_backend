package com.workops.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Component;

public interface ComponentDao  extends JpaRepository <Component,String> {

	Optional<Component> findByName(String Name);
}
