package com.chardy.springSisTurn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.dto.TurnDTO;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Turn;
import com.chardy.springSisTurn.entity.User;
import com.chardy.springSisTurn.repository.ITurnDAO;
import com.chardy.springSisTurn.wrapper.EventWrapper;
import com.chardy.springSisTurn.wrapper.TurnWrapper;

@Service
public class TurnServiceImpl implements ITurnService{
	
	@Autowired
	private ITurnDAO turnDAO;
	
	
	@Override
	public List<Turn> getAll() {
		return turnDAO.findAll();
	}
	
	@Override
	public User findByToken(String token) {
		return turnDAO.findByToken(token);
	}

	@Override
	public Event findEventById(Long id) {
		// TODO Auto-generated method stub
		return turnDAO.findEventById(id);
	}

	@Override
	public TurnDTO save(TurnDTO turnDTO) {
		
		Turn turn = TurnWrapper.dtoToEntity(turnDTO);
		
		turn.setActive(true);
			
			turn = turnDAO.save(turn);
			turnDTO = TurnWrapper.entityToDto(turn);
			return turnDTO;
		}

	@Override
	public TurnDTO save(Turn turn) {
		
		turn.setActive(true);
		//event.setOrganization();
		turn = turnDAO.save(turn);
		
		TurnDTO turnDTO = TurnWrapper.entityToDto(turn);
		
		return turnDTO;
	}

}
