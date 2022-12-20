package com.chardy.springSisTurn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;

public interface IEventDAO extends JpaRepository<Event, Long>{
	
	@Query("select u from organizations u where u.token = ?1")
	public Organization findByToken(String tokenOrg);

}
