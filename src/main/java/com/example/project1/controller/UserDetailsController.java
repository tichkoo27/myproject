package com.example.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.payLoad.UserDetailsType;
import com.example.project1.service.UserService;


@RequestMapping("/project1/user")
@RestController
public class UserDetailsController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/getUserDetails", produces="application/json")
	public List<UserDetailsType> getUserDetails() {
		
		List<UserDetailsType> userDetailsTypeList = userService.getUserDetails();
		return userDetailsTypeList;
	}
	
	@GetMapping("/getUsersByName")
	public List<UserDetailsType> getUsersByName(@RequestParam String name) {
		
		List<UserDetailsType> userDetailsTypeList = userService.getUsersByName(name);
		return userDetailsTypeList;
	}
	
	@PostMapping(value="/createUser", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public UserDetailsType createUser(@RequestBody UserDetailsType userDetailsType) {
		UserDetailsType userResult = userService.createUser(userDetailsType);
		return userResult;
		
	}
}
