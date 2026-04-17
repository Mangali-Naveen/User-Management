package com.user.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.user.demo.dto.UsersRequestDto;
import com.user.demo.dto.UsersResponseDto;
import com.user.demo.entity.Users;
import com.user.demo.repository.Repository;



@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private PasswordEncoder encoder;
	
	Repository repo;

	public UserService(Repository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String register(UsersRequestDto user) {
		
		if (repo.existsByUserName(user.getUserName())) {
			return "Username already exists";
		} 
		
		if (repo.existsByEmail(user.getEmail())) {
			return "Email already exists";
		}
		if (repo.existsByMobile(user.getMobile())) {
			return "Mobile number already exists";
		}


		// Save data if not exists
		Users entity = new Users();
		entity.setUserName(user.getUserName());
		entity.setPassword(encoder.encode(user.getPassword()));
		entity.setEmail(user.getEmail());
		entity.setGender(user.getGender());
		entity.setMobile(user.getMobile());
		entity.setAddress(user.getAddress());
		entity.setDod(user.getDod());
		entity.setDpurl(user.getDpurl());
		repo.save(entity);
		return "Registered successfully";
	}

	@Override
	public UsersResponseDto searchUser(Long id) {
		// TODO Auto-generated method stub
		Users res = repo.findById(id).orElse(null);
		
		if (res != null) {
			UsersResponseDto dto = new UsersResponseDto();
			
			dto.setUserName(res.getUserName());
			dto.setEmail(res.getEmail());
			dto.setGender(res.getGender());
			dto.setMobile(res.getMobile());
			dto.setAddress(res.getAddress());
			dto.setDod(res.getDod());
			dto.setDpurl(res.getDpurl());
			
			return dto;
		}
		return null;
	}

	@Override
	public List<UsersResponseDto> viewAllUsers() {

	    List<Users> users = repo.findAll();

	    List<UsersResponseDto> dtoList = new ArrayList<>();

	    for (Users u : users) {
	        UsersResponseDto dto = new UsersResponseDto();
			dto.setUserName(u.getUserName());
			dto.setEmail(u.getEmail());
			dto.setGender(u.getGender());
			dto.setMobile(u.getMobile());
			dto.setAddress(u.getAddress());
			dto.setDod(u.getDod());
			dto.setDpurl(u.getDpurl());

	        dtoList.add(dto);
	    }

	    return dtoList;
	}
	
	
	@Override
	public String updateUser(Long id, Users user) {

	    Users res = repo.findById(id).orElse(null);

	    if (res != null) {
	        user.setId(id);
	        repo.save(user);
	        return "Users details Successfully updated..";
	    }

	    return "User not found can not be updated";
	}
	
	

	@Override
	public String deleteUser(Long id) {

	    Users res = repo.findById(id).orElse(null);

	    if (res != null) {
	        repo.deleteById(id);
	        return "Users details Successfully Deleted..";
	    }

	    return "User not found can not be Deleted";
	}
	
	
}
