package com.chardy.springSisTurn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.User;
import com.chardy.springSisTurn.repository.ITurnDAO;

@Service
public class TurnServiceImpl implements ITurnService{
	
	@Autowired
	private ITurnDAO turnDAO;

	@Override
	public User findByToken(String token) {
		return turnDAO.findByToken(token);
	}

	@Override
	public Event findEventById(Long id) {
		// TODO Auto-generated method stub
		return turnDAO.findEventById(id);
	}

}
