package com.workops.service;

import java.util.List;
import java.util.Optional;

import com.workops.model.Sprint;
import com.workops.pojo.SprintData;

public interface SprintService {

	List<Sprint> getAllSprints();
	Optional<Sprint> getSprintById(String sprintid)throws Exception;
	Optional<Sprint> getSprintByName(String name)throws Exception;
	Sprint createSprint(SprintData sprint) throws Exception;
	Sprint updateSprint(Sprint sprint);
	void deleteSprintById(String sprintid) throws Exception;
	List<Sprint> getSprintByProjectid(String projectid) throws Exception;
	
}
