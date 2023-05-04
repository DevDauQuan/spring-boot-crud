package com.springbootcrud.services.implement;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcrud.data.dto.UserDTO;
import com.springbootcrud.data.dto.UserRegisterDTO;
import com.springbootcrud.data.entity.UserEntity;
import com.springbootcrud.data.mapper.UserMapper;
import com.springbootcrud.exception.ExceptionCustom;
import com.springbootcrud.repository.IUserRepository;
import com.springbootcrud.services.IUserService;
import com.springbootcrud.utils.Encoding;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository iUserRepository;

	@Autowired
	UserMapper mapper;

	@Override
	public UserDTO registerUser(UserRegisterDTO userRegisterDTO) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		UserEntity user = iUserRepository.save(mapper.toEntity(userRegisterDTO));

		return mapper.toDTO(user);
	}

	@Override
	public UserDTO updateUser(long id, UserDTO userDTO) {
		// TODO Auto-generated method stub
		UserEntity user = iUserRepository.findById(id)
				.orElseThrow(() -> new ExceptionCustom("User", "Not Existed", "id", id));

		UserEntity userEntity = mapper.toEntity(userDTO);
		userEntity.setId(id);
		userEntity.setPassword(user.getPassword());
		iUserRepository.save(userEntity);

		return mapper.toDTO(userEntity);
	}

	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
		return iUserRepository.findAll().stream().map(u -> mapper.toDTO(u)).collect(Collectors.toList());
	}

	@Override
	public UserDTO loginUser(UserRegisterDTO userDTO) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		UserEntity user = iUserRepository.findByUsername(userDTO.getUsername());

//		System.out.println(user);
//		System.out.println(Encoding.getMD5(userDTO.getPassword()));
		if (user.getPassword().equals(Encoding.getMD5(userDTO.getPassword()))) {
			return mapper.toDTO(user);
		}
		return null;
	}

}
