package com.chardy.springSisTurn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.chardy.springSisTurn.entity.User;
import com.chardy.springSisTurn.repository.IUserDAO;

public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDAO userDAO;
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

}
