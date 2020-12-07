package com.workops.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workops.dao.VersionDao;
import com.workops.dao.ProjectDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Version;
import com.workops.model.Project;

@Service
@Transactional
public class VersionServiceImpl implements VersionService {

	@Autowired
	VersionDao Versiondao;
	
	@Autowired
	ProjectDao projectdao;
	@Override
	public List<Version> getAllVersions() {
		return Versiondao.findAll();
	}

	@Override
	public List<Version> getAllVersionByProjectId(String projectid) throws Exception {
	
		try
		{
			List<Version> com=Versiondao.findByProject(projectdao.findById(projectid).get());
//		if(!com.isPresent())
//		{
//			throw  new ErrorDetails("Not Found Version With Given Id");
//		}
		return com;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Version createVersion(Version Version) throws Exception {
		try
		{
		Optional<Version> com=Versiondao.findByName(Version.getName());
		if(!com.isPresent())
		{
			Version.setId(UUID.randomUUID().toString().substring(0,32));
			return Versiondao.save(Version);
		}
		throw new ErrorDetails("Version Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage()+" =?"+Version.getDescription());
		}
	}

	@Override
	public Version updateVersion(Version Version) {
		return Versiondao.save(Version);
	}

	@Override
	public void deleteVersionById(String Versionid) throws Exception {
		try
		{
		Optional<Version> com=Versiondao.findById(Versionid);
		if(!com.isPresent())
		{

			throw new ErrorDetails("No Project Exists With this Id");
		}
		Versiondao.deleteById(Versionid);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
		
	}

	@Override
	public Optional<Version> getVersionById(String cid) throws Exception {
		try
		{
			Optional<Version> com=Versiondao.findById(cid);
		if(!com.isPresent())
		{
			throw  new ErrorDetails("Not Found Version With Given Id");
		}
		return com;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	
}
