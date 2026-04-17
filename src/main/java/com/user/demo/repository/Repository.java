package com.user.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.demo.entity.Users;

public interface Repository extends JpaRepository<Users,Long> {
	boolean existsByUserName(String userName);
	boolean existsByEmail(String email);
	boolean existsByMobile(String mobile);
}
