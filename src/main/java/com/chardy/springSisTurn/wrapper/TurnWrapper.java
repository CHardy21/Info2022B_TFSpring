package com.chardy.springSisTurn.wrapper;

import com.chardy.springSisTurn.dto.TurnDTO;
import com.chardy.springSisTurn.entity.Turn;

public class TurnWrapper {
	
	public static Turn dtoToEntity(TurnDTO dto) {		
		
		if(dto == null) return new Turn();
		
		Turn entity = new Turn();
		entity.setNameEvent(dto.getNameEvent());
		entity.setDateTurn(dto.getDateTurn());
		entity.setIdEvent(dto.getIdEvent());

		
		return entity;
	}

}
