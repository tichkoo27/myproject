package com.example.project1.service;

import java.util.List;

import com.example.project1.payLoad.UserDetailsType;

public interface UserService {
	List<UserDetailsType> getUserDetails();
	List<UserDetailsType> getUsersByName(String name);
}
