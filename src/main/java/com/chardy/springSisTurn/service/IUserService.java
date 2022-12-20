package com.chardy.springSisTurn.service;

import java.util.List;

import com.chardy.springSisTurn.dto.UserDTO;
import com.chardy.springSisTurn.entity.User;

public interface IUserService {
	
	public List<User> getAll();
	public List<User> getAllActive();
	public User findByDni(String dni);
	public User findByToken(String token);
	public User findByLastName(String lastname);
	
	public UserDTO save(UserDTO user);
	public User save(User user);
	public User delete(User user);
	public UserDTO update(UserDTO user,String token);

}
