package com.manoj.userservice.service.impl;

import javax.transaction.Transactional;

import com.manoj.userservice.constants.Constants;
import com.manoj.userservice.dao.UserMgtDao;
import com.manoj.userservice.service.UserMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMgtServiceImpl implements UserMgtService {

	@Autowired
	UserMgtDao userMgtDao;
	
	@Transactional
	@Override
	public boolean cleanUserDb(String password, String username) {
		if(!password.equals(Constants.DELETE_DB_DATA_PASSWORD)) {
			return Constants.FALSE;
		}
		return userMgtDao.cleanUserDb(username);
	}

}
