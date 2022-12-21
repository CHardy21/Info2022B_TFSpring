package com.chardy.springSisTurn.service;

import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.User;

public interface ITurnService {
	
	
	
	public User findByToken(String token);
	public Event findEventById(Long id);
}
