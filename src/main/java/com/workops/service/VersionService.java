package com.workops.service;

import java.util.List;
import java.util.Optional;

import com.workops.model.Version;

public interface VersionService {

	List<Version> getAllVersions();
	Optional<Version> getVersionById(String cid)throws Exception;
	List<Version> getAllVersionByProjectId(String projectid)throws Exception;
	Version createVersion(Version Version) throws Exception;
	Version updateVersion(Version Version) ;
	void deleteVersionById(String Versionid) throws Exception;
}
