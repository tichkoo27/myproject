package com.example.project1.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Project1_User_Details")
public class UserDetails implements Serializable{

	@Column(name="name")
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="dob")
	private Date dob;

	@Column(name="address")
	private String address;
	
	@Column(name="salary")
	private Long salary;
	
	@Column(name="manager_id")
	private Long managerId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private Long phoneNumber;
	
}
