package com.workops.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.workops.model.User;


public interface UserDao extends JpaRepository <User,String>{

	User findByEmail(String email);
	@Modifying
	@Query("update User u set u.token =:token where u.email=:email")
	@Transactional
	void updateTokenByEmail(@Param("email") String email,@Param("token") String token);
	@Query("select token from User u where u.email=:email")
	@Transactional
	String getTokenByEmail(@Param("email") String email);
}
