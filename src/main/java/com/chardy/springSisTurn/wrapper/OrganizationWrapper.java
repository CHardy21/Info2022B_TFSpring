package com.chardy.springSisTurn.wrapper;

import com.chardy.springSisTurn.dto.OrganizationDto;
import com.chardy.springSisTurn.entity.Organization;


public class OrganizationWrapper {
	
	public static Organization dtoToEntity(OrganizationDto dto) {		
		if(dto == null) return new Organization();
		
		Organization entity = new Organization();
		entity.setName(dto.getName());
		entity.setCuit(dto.getCuit());
		entity.setAddress(dto.getAddress());
		entity.setPhone(dto.getPhone());
		entity.setEmail(dto.getEmail());
		
		return entity;
	}
	
	
	public static OrganizationDto entityToDto(Organization entity) {
		// poner solo lo que queremos mostrar
		// en principio tiene los mismos campos q el dto
		
		if(entity == null) return new OrganizationDto();
		
		OrganizationDto dto = new OrganizationDto();
		dto.setName(entity.getName());
		dto.setAddress(entity.getAddress());
		dto.setCuit(entity.getCuit());
		dto.setEmail(entity.getEmail());
		dto.setPhone(entity.getPhone());
		//dto.setActive(false);
		return dto;
	}
	
}
