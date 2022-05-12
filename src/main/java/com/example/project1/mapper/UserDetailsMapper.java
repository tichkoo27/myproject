package com.example.project1.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.project1.entity.UserDetails;
import com.example.project1.payLoad.UserDetailsType;

public class UserDetailsMapper implements RowMapper<UserDetailsType>{

	@Override
	public UserDetailsType mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		UserDetailsType userDetailsType = new UserDetailsType();
		
		userDetailsType.setName(rs.getString("name"));
		userDetailsType.setUserId(rs.getLong("user_id"));
		userDetailsType.setDob(rs.getDate("dob"));
		userDetailsType.setAddress(rs.getString("address"));
		userDetailsType.setSalary(rs.getLong("salary"));
		userDetailsType.setManagerId(rs.getLong("manager_id"));
		userDetailsType.setEmail(rs.getString("email"));
		userDetailsType.setPhoneNumber(rs.getLong("phone"));
		
		return userDetailsType;
		
	}
	
//	public UserDetails userDetailsTypeToUserDetails(UserDetailsType userDetailsType) {
//		
//		
//		UserDetails userDetails = new UserDetails();
//		
//		userDetails.setName(userDetailsType.getName());
//		userDetails.setDob(userDetailsType.getDob());
//		userDetails.setAddress(userDetailsType.getAddress());
//		userDetails.setSalary(userDetailsType.getSalary());
//		userDetails.setManagerId(userDetailsType.getManagerId());
//		userDetails.setEmail(userDetailsType.getEmail());
//		userDetails.setPhoneNumber(userDetailsType.getPhoneNumber());
//		
//		
//		return userDetails;
//		
//	}
	
}
