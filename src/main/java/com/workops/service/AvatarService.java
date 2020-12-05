package com.workops.service;

import java.util.List;
import java.util.Optional;

import com.workops.model.Avatar;

public interface AvatarService {


	List<Avatar> getAllAvatars();
	Optional<Avatar> getAvatarById(String avatarid)throws Exception;
	Avatar createAvatar(Avatar avatar) throws Exception;
	Avatar updateAvatar(Avatar Vavatar) ;
	void deleteAvatarId(String Avatar) throws Exception;
}
