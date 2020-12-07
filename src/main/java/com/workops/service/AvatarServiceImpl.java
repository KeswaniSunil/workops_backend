package com.workops.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.AvatarDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.Avatar;
import com.workops.model.Component;
import com.workops.model.Issuetype;
import com.workops.model.Project;

@Service
@Transactional
public class AvatarServiceImpl implements AvatarService {

	@Autowired 
	AvatarDao adao;
	@Override
	public List<Avatar> getAllAvatars() {
		return adao.findAll();
	}

	@Override
	public Optional<Avatar> getAvatarById(String avatarid) throws Exception {
		try
		{
		Optional<Avatar> avatar=adao.findById(avatarid);
		if(!avatar.isPresent())
		{
			throw  new ErrorDetails("Not Found Project With Given Id");
		}
		return avatar;
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public Avatar createAvatar(Avatar avatar) throws Exception {
		try {
			Optional<Avatar> check=adao.findByName(avatar.getName());
			if(!check.isPresent())
			{
				avatar.setId(UUID.randomUUID().toString().substring(0,32));
				return adao.save(avatar);
			}
			throw new ErrorDetails("avatar Already Exists");
			}
			catch(Exception e)
			{
				throw new ErrorDetails(e.getMessage());
			}
	}

	@Override
	public Avatar updateAvatar(Avatar avatar) {
		return adao.save(avatar);
	}

	@Override
	public void deleteAvatarId(String avatarid) throws Exception {
		try
		{
		Optional<Avatar> com=adao.findById(avatarid);
		if(!com.isPresent())
		{

			throw new ErrorDetails("No AVatar Exists With this Id");
		}
		adao.deleteById(avatarid);
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}

}
