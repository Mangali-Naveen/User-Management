package com.user.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.demo.dto.UsersRequestDto;
import com.user.demo.dto.UsersResponseDto;
import com.user.demo.entity.Users;
import com.user.demo.service.UserService;

@RestController
public class UserController {
	
	UserService service;

	public UserController(UserService service) {
		super();
		this.service = service;
	}

	// user Register 
	@PostMapping("/add")
	public String register(@RequestBody UsersRequestDto user) {
		return service.register(user);
	}
	
	// search by id 
	@GetMapping("/searchUser/{id}")
	public Object viewUser(@PathVariable Long id) {
		UsersResponseDto dto = service.searchUser(id);
		
		if (dto != null) {
			return dto;
		}
		return "Not found";
	}
	
	// search all students
	@GetMapping("/viewAllUsers")
	public List<UsersResponseDto> viewAllUsers() {
		return service.viewAllUsers();
	}
	
	
	// update user
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable Long id, @RequestBody Users user) {
		return service.updateUser(id, user);
	}
	
	// delete user
	@DeleteMapping("deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		return service.deleteUser(id);
	}
}
