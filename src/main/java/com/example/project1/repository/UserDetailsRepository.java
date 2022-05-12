package com.example.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project1.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

}
