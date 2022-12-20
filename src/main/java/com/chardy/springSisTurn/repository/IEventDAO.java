package com.chardy.springSisTurn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chardy.springSisTurn.entity.Event;

public interface IEventDAO extends JpaRepository<Event, Long>{
	
	

}
