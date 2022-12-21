package com.chardy.springSisTurn.service;

import java.util.List;

import com.chardy.springSisTurn.dto.TurnDTO;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Turn;
import com.chardy.springSisTurn.entity.User;

public interface ITurnService {
	
	public List<Turn> getAll();
	
	public TurnDTO save(TurnDTO turnDTO);
	public TurnDTO save(Turn turn);
	
	public User findByToken(String token);
	public Event findEventById(Long id);
}
