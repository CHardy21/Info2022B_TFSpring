package com.chardy.springSisTurn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;

@Repository
public interface IEventDAO extends JpaRepository<Event, Long>{
	
	public List<Event> findAll();
	
	@Query("select u from events u where u.active = 1")
	public List<Event> findByActive();
	
	//@Query("select u from events u where u.organizationsId = ?1")
	//public List<Event> findAllEventsOrg(Long id);
	
	
	
	@Query("select u from organizations u where u.token = ?1")
	public Organization findByToken(String tokenOrg);
	@Query("select u from organizations u where u.cuit = ?1")
	public Organization findByCuit(String cuit);
}
