package com.example.project1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.daoImpl.UserDaoImpl;
import com.example.project1.payLoad.UserDetailsType;
import com.example.project1.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Override
	public List<UserDetailsType> getUserDetails() {
		
		return userDaoImpl.getUserDetails();
	}

	@Override
	public List<UserDetailsType> getUsersByName(String name) {

		return userDaoImpl.getUsersByName(name);
	}

	
	
}
