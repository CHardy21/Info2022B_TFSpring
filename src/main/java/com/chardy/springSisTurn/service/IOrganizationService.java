package com.chardy.springSisTurn.service;

import java.util.List;

import com.chardy.springSisTurn.dto.OrganizationDto;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;



public interface IOrganizationService {

	public List<Organization> getAll();
	public List<Organization> getAllActive();
	//public List<Event> findAllEvents(Long id);
	public Organization findByCuit(String cuit);
	public Organization findByName(String name);
	public Organization findByToken(String token);
		
	public OrganizationDto save(OrganizationDto organization);
	public Organization save(Organization organization);
	public Organization delete(Organization organization);
	public OrganizationDto update(OrganizationDto organizacion,String token);

	


	
}
