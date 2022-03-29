package com.example.project1.dao;

import java.util.List;

import com.example.project1.payLoad.UserDetailsType;


public interface UserDao {
	List<UserDetailsType> getUserDetails();
	List<UserDetailsType> getUsersByName(String name);
}
