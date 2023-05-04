package com.springbootcrud.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.data.dto.UserDTO;
import com.springbootcrud.data.dto.UserRegisterDTO;
import com.springbootcrud.services.IUserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user/")
public class UserController {

	@Autowired
	IUserService service;

	@PostMapping("")
	public UserDTO registerUser(@RequestBody UserRegisterDTO user) throws NoSuchAlgorithmException {
		return service.registerUser(user);
	}

	@PutMapping("{id}")
	public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO user) {
		return service.updateUser(id, user);
	}

	@GetMapping("")
	public List<UserDTO> getAllUser() {
		return service.getAllUser();
	}

	@PostMapping("/login")
	public UserDTO loginUser(@RequestBody UserRegisterDTO user) throws NoSuchAlgorithmException {
		return service.loginUser(user);
	}
}
