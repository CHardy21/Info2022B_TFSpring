package com.chardy.springSisTurn.repository;

import java.util.List;

import com.chardy.springSisTurn.entity.User;

public interface IUserDAO {
	
	public List<User> findAll();

}
