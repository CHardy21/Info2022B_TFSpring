package com.chardy.springSisTurn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chardy.springSisTurn.entity.User;
import com.chardy.springSisTurn.repository.IUserDAO;

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

}
