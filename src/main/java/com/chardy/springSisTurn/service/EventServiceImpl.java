package com.chardy.springSisTurn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.repository.IEventDAO;
import com.chardy.springSisTurn.wrapper.EventWrapper;


@Service
public class EventServiceImpl implements IEventService{
	
	@Autowired
	private IEventDAO eventDAO;
	
	@Override
	public List<Event> getAll() {
		return eventDAO.findAll();
	}
	
	@Override
	public List<Event> getAllActive() {
		return eventDAO.findByActive();
	}


	@Override
	public Organization findByCuit(String cuit) { 
		return eventDAO.findByCuit(cuit);
	}
	@Override
	public Organization findByToken(String tokenOrg) {
		return eventDAO.findByToken(tokenOrg);
	}
	
	
	@Override
	public EventDTO save(EventDTO eventDTO) {
		
		Event event = EventWrapper.dtoToEntity(eventDTO);
		
		event.setActive(true);
			
			event = eventDAO.save(event);
			eventDTO = EventWrapper.entityToDto(event);
			return eventDTO;
		}
	@Override
	public EventDTO save(Event event) {
		
		event.setActive(true);
		//event.setOrganization();
		event = eventDAO.save(event);
		
		EventDTO eventDTO = EventWrapper.entityToDto(event);
		
		return eventDTO;
	}

	@Override
	public Optional<Event> findById(Long id) {
		return eventDAO.findById(id);
	}

	@Override
	public Event delete(Long id) {
		Event eventDeleted = eventDAO.getById(id);
		eventDAO.delete(id);
		
		return eventDeleted;
		
	}
	@Override
	public EventDTO update(EventDTO event, Long id) {
		
		Optional<Event> optinalEntity = eventDAO.findById(id);
		Event existEvent = optinalEntity.get();
		Event newUpdateEvent = EventWrapper.dtoToEntity(event);
		
		newUpdateEvent.setId(existEvent.getId());
		newUpdateEvent.setActive(existEvent.getActive());
		newUpdateEvent.setDateInit(existEvent.getDateInit());
		
		newUpdateEvent.setCreationDate(existEvent.getCreationDate());
		newUpdateEvent.setTurns(existEvent.getTurns());
		newUpdateEvent.setOrganization(existEvent.getOrganization());
		
		Event updateEvent = eventDAO.save(newUpdateEvent);
		
			if(updateEvent != null) {
				EventDTO updateOrgDto = EventWrapper.entityToDto(updateEvent);
			return updateOrgDto;
		}
		
		return null;
	}

}
