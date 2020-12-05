package com.workops.service;

import java.util.List;
import java.util.Optional;

import com.workops.model.Userprofile;

public interface UserprofileService {

	List<Userprofile> getAllUserprofiles();
	Optional<Userprofile> getUserprofileByEmail(String email) throws Exception;
	Userprofile createUserprofile(Userprofile userprofile) throws Exception;
	Userprofile updateUserprofile(Userprofile userprofile) ;
	void deleteUserprofileByEmail(String email) throws Exception;
	void setSelectedProject(Userprofile userprofile) throws Exception;
}
