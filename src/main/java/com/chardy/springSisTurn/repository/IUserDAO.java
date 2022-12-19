package com.chardy.springSisTurn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chardy.springSisTurn.entity.User;

public interface IUserDAO extends JpaRepository<User, Long>{
	
	public List<User> findAll();
	
	@Query("select u from users u where u.active = 1")
	public List<User> findByActive();

}
