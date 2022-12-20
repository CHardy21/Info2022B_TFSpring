package com.chardy.springSisTurn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.dto.OrganizationDto;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.repository.IEventDAO;
import com.chardy.springSisTurn.wrapper.OrganizationWrapper;


@Service
public class EventServiceImpl implements IEventService{
	
	@Autowired
	private IEventDAO eventDAO;

	@Override
	public EventDTO save(EventDTO eventDTO) {
		
		Event event = EventWrapper.dtoToEntity(eventDTO);
		
		
		event.setActive(true);
		
			
			organization = organizationDao.save(organization);
			organizationDto = OrganizationWrapper.entityToDto(organization);
			return organizationDto;
		}

	@Override
	public Event save(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

}
