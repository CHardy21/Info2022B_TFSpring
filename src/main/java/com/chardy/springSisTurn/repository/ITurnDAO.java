package com.chardy.springSisTurn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Turn;
import com.chardy.springSisTurn.entity.User;

public interface ITurnDAO  extends JpaRepository<Turn, Long>{

	@Query("select u from users u where u.token = ?1")
	public User findByToken(String tokenOrg);
	
	@Query("select u from events u where u.id = ?1")
	public Event findEventById(Long id);
}
