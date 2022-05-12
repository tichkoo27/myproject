package com.example.project1.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.project1.dao.UserDao;
import com.example.project1.mapper.UserDetailsMapper;
import com.example.project1.payLoad.UserDetailsType;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private final static String User_query = "Select * from Project1_User_Details ";
	
	@Override
	public List<UserDetailsType> getUserDetails() {
		
		return namedParameterJdbcTemplate.query(User_query, new UserDetailsMapper());
	}

	@Override
	public List<UserDetailsType> getUsersByName(String name) {
		
		return namedParameterJdbcTemplate.query(User_query+"where name like '%"+name+"%' ", new UserDetailsMapper());
	}

	
	
}
