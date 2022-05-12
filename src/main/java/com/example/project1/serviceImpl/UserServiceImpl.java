package com.example.project1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.daoImpl.UserDaoImpl;
import com.example.project1.entity.UserDetails;
import com.example.project1.mapper.UserDetailsMapper;
import com.example.project1.payLoad.UserDetailsType;
import com.example.project1.repository.UserDetailsRepository;
import com.example.project1.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Override
	public List<UserDetailsType> getUserDetails() {
		
		return userDaoImpl.getUserDetails();
	}

	@Override
	public List<UserDetailsType> getUsersByName(String name) {

		return userDaoImpl.getUsersByName(name);
	}

	@Override
	public UserDetailsType createUser(UserDetailsType userDetailsType) {
		
//		UserDetails userDetails=UserDetailsMapper.userDetailsTypeToUserDetails(userDetailsType);
		UserDetails userDetails = new UserDetails();
		
		userDetails.setName(userDetailsType.getName());
		userDetails.setDob(userDetailsType.getDob());
		userDetails.setAddress(userDetailsType.getAddress());
		userDetails.setSalary(userDetailsType.getSalary());
		userDetails.setManagerId(userDetailsType.getManagerId());
		userDetails.setEmail(userDetailsType.getEmail());
		userDetails.setPhoneNumber(userDetailsType.getPhoneNumber());
		
		userDetailsRepository.save(userDetails);
		
		return userDetailsType;
	}

	
	
}
