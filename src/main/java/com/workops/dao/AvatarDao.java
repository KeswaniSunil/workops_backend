package com.workops.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workops.model.Avatar;

public interface AvatarDao extends JpaRepository <Avatar,String>{

	Optional<Avatar> findByName(String Name);
	Optional<Avatar> findByUrl(String url);
}
