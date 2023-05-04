package com.springbootcrud.data.mapper;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.springbootcrud.data.dto.UserDTO;
import com.springbootcrud.data.dto.UserRegisterDTO;
import com.springbootcrud.data.entity.UserEntity;

@Component
public class UserMapper {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserEntity toEntity(UserRegisterDTO userRegisterDTO) throws NoSuchAlgorithmException {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(userRegisterDTO.getUsername());
		userEntity.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
		userEntity.setRole(userRegisterDTO.getRole());
		return userEntity;
	}

	public UserDTO toDTO(UserEntity userEntity) {
		UserDTO dto = new UserDTO();
		dto.setId(userEntity.getId());
		dto.setUsername(userEntity.getUsername());
		dto.setRole(userEntity.getRole());
		return dto;
	}

	public UserEntity toEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userDTO.getId());
		userEntity.setUsername(userDTO.getUsername());
		userEntity.setRole(userDTO.getRole());
		return userEntity;
	}
}
