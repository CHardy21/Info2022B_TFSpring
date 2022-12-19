package com.chardy.springSisTurn.wrapper;

import com.chardy.springSisTurn.dto.UserDTO;
import com.chardy.springSisTurn.entity.User;

public class UserWrapper {

	public static User dtoToEntity(UserDTO dto) {		
		if(dto == null) return new User();
		
		User entity = new User();
		entity.setName(dto.getName());
		entity.setLastName(dto.getLastName());
		entity.setDni(dto.getDni());
		entity.setPhone(dto.getPhone());
		entity.setEmail(dto.getEmail());
		
		return entity;
	}
	
	
	public static UserDTO entityToDto(User entity) {
		// poner solo lo que queremos mostrar
		// en principio tiene los mismos campos q el dto
		
		if(entity == null) return new UserDTO();
		
		UserDTO dto = new UserDTO();
		dto.setName(entity.getName());
		dto.setLastName(entity.getLastName());
		dto.setDni(entity.getDni());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		//dto.setActive(false);
		return dto;
	}
	
}
