package com.springbootcrud.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.springbootcrud.data.dto.UserDTO;
import com.springbootcrud.data.dto.UserRegisterDTO;

public interface IUserService {

	public UserDTO registerUser(UserRegisterDTO userDTO) throws NoSuchAlgorithmException;

	public UserDTO updateUser(long id, UserDTO userDTO);

	public List<UserDTO> getAllUser();

	public UserDTO loginUser(UserRegisterDTO userDTO) throws NoSuchAlgorithmException;
}
