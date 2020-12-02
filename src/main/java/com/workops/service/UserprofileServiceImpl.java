package com.workops.service;

import java.util.List;
import java.util.Optional;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workops.dao.UserprofileDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Userprofile;


@Service
@Transactional
public class UserprofileServiceImpl implements UserprofileService {

	@Autowired
	UserprofileDao upd;
	@Override
	public List<Userprofile> getAllUserprofiles() {
		return upd.findAll();
	}

	@Override
	public Optional<Userprofile> getUserprofileByEmail(Userprofile userprofile) throws Exception {
		try
		{
		Optional<Userprofile> p=upd.findByEmail(userprofile.getEmail());
		if(!p.isPresent())
		{
			throw  new ErrorDetails("Not Found Project With Given Id");
		}
		return p;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Userprofile createUserprofile(Userprofile userprofile) throws Exception {
		try
		{
		Optional<Userprofile> p=upd.findByEmail(userprofile.getEmail());
		if(!p.isPresent())
		{
			return upd.save(userprofile);
		}
		throw new ErrorDetails("Project Already Exists");
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Userprofile updateUserprofile(Userprofile userprofile) {
	return upd.save(userprofile);
	}

	@Override
	public void deleteUserprofileByEmail(Userprofile userprofile) throws Exception {
		try
		{
		Optional<Userprofile> p=upd.findByEmail(userprofile.getEmail());
		if(!p.isPresent())
		{

			throw new ErrorDetails("No Project Exists With this Id");
		}
		upd.deleteById(userprofile.getEmail());
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public void setSelectedProject(Userprofile userprofile) throws Exception {
		try
		{
			upd.setSelectedProjectByEmail(userprofile.getEmail(), userprofile.getSelectedProject());
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
		
	}

}
