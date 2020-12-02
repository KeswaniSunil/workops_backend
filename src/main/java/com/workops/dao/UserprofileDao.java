package com.workops.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.workops.model.Userprofile;

public interface UserprofileDao extends JpaRepository <Userprofile,String> {


	public Optional<Userprofile> findByEmail(String email);
	public void deleteByEmail(String email);
	@Modifying
	@Query("update Userprofile u set u.selectedProject =:selectedproject where u.email=:email")
	@Transactional
	void setSelectedProjectByEmail(@Param("email") String email,@Param("selectedproject") String selectedproject);
}
