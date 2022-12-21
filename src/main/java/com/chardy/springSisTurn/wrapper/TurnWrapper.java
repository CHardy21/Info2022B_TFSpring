package com.chardy.springSisTurn.wrapper;

import com.chardy.springSisTurn.dto.TurnDTO;
import com.chardy.springSisTurn.entity.Turn;

public class TurnWrapper {
	
	public static Turn dtoToEntity(TurnDTO dto) {		
		
		if(dto == null) return new Turn();
		
		Turn entity = new Turn();
		entity.setNameEvent(dto.getNameEvent());
		entity.setDateTurn(dto.getDateTurn());
				
		return entity;
	}

	public static TurnDTO entityToDto(Turn entity) {
		// poner solo lo que queremos mostrar
		// en principio tiene los mismos campos q el dto
		
		if(entity == null) return new TurnDTO();
		
		TurnDTO dto = new TurnDTO();
		dto.setNameEvent(entity.getNameEvent());
		dto.setDateTurn(entity.getDateTurn());
		
		return dto;
	}
	
}
