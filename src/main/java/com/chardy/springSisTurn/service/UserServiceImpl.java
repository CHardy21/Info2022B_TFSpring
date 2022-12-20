package com.chardy.springSisTurn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chardy.springSisTurn.dto.UserDTO;
import com.chardy.springSisTurn.entity.User;
import com.chardy.springSisTurn.repository.IUserDAO;
import com.chardy.springSisTurn.wrapper.UserWrapper;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDAO userDAO;
	
	
	@Override
	public List<User> getAll() {
		return userDAO.findAll();
	}
	
	@Override
	public List<User> getAllActive() {
		return userDAO.findByActive();
	}

	@Override
	public User findByDni(String dni) {
		return userDAO.findByDni(dni);
		
	}
	
	@Override
	public User findByLastName(String lastname) {
		return userDAO.findByLastName(lastname);
	}

	@Override
	public User findByToken(String token) {
		return userDAO.findByToken(token);
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		
		User user = UserWrapper.dtoToEntity(userDTO);
		
		// Code to generate token
		user.setActive(true);
		user.setToken("token"+user.getEmail()+user.getPhone());
		
		user = userDAO.save(user);
		userDTO = UserWrapper.entityToDto(user);
		return userDTO;
	}

	@Override
	public User save(User user) {
		
		String token = user.getToken();
		
		User deleteUser = userDAO.findByToken(token);
			if(deleteUser != null) {
				deleteUser.setActive(false);
				userDAO.delete(token);
			return deleteUser;
		}
		return deleteUser;
	}

	@Override
	public User delete(User user) {
		
		String token = user.getToken();
		
		User deleteUser = userDAO.findByToken(token);
			if(deleteUser != null) {
				deleteUser.setActive(false);
				userDAO.delete(token);
			return deleteUser;
		}
		return deleteUser;
	}

	@Override
	public UserDTO update(UserDTO user, String token) {

		User existUser = userDAO.findByToken(token);
		User newUpdateUser = UserWrapper.dtoToEntity(user);
		
		//existOrg.setName(token);
		newUpdateUser.setId(existUser.getId());
		newUpdateUser.setActive(existUser.getActive());
		newUpdateUser.setCreateDate(existUser.getCreateDate());
		//newUpdateUser.setEvents(existUser.getEvents());
		newUpdateUser.setToken(token);
		
		User updateUser = userDAO.save(newUpdateUser);
		
			if(updateUser != null) {
				UserDTO updateUserDTO = UserWrapper.entityToDto(updateUser);
			return updateUserDTO;
		}
		
		return null;
	}




}
