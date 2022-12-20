package com.chardy.springSisTurn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;

public interface IEventDAO extends JpaRepository<Event, Long>{
	
	public List<Event> findAll();
	
	@Query("select u from events u where u.active = 1 AND u.dateFin < now()")
	public List<Event> findByActive();
	
	
	
	@Query("select u from organizations u where u.token = ?1")
	public Organization findByToken(String tokenOrg);

}
