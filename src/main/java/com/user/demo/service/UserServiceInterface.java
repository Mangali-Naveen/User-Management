package com.user.demo.service;

import java.util.List;

import com.user.demo.dto.UsersRequestDto;
import com.user.demo.dto.UsersResponseDto;
import com.user.demo.entity.Users;

public interface UserServiceInterface {
	
	String register(UsersRequestDto user);
	UsersResponseDto searchUser(Long id);
	List<UsersResponseDto> viewAllUsers();
	String updateUser(Long id,Users user);
	String deleteUser(Long id);
}
