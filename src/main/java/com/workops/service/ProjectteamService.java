package com.workops.service;

import java.util.List;
import java.util.Optional;

import com.workops.model.Projectteam;
import com.workops.model.ProjectteamPK;

public interface ProjectteamService {

	
	Projectteam createProjectteam(Projectteam project) throws Exception;
	List<Projectteam> getAllProjectteams();
	Optional<Projectteam> getProjectteamById(ProjectteamPK id)throws Exception;
//	Projectteam createProject(Projectteam projectteam) throws Exception;
//	Projectteam updateProject(Projectteam projectteam) ;
	List<Projectteam> getProjectteamByProjectId(String projectid) throws Exception;
	void deleteProjectteamByProjectId(String projectid) throws Exception;
	void deleteProjectteamByEmail(ProjectteamPK id) throws Exception;
}
