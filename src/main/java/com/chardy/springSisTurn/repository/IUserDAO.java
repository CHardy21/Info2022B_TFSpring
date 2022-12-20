package com.chardy.springSisTurn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.chardy.springSisTurn.entity.User;

public interface IUserDAO extends JpaRepository<User, Long>{
	
	public List<User> findAll();
	
	@Query("select u from users u where u.active = 1")
	public List<User> findByActive();
	
	@Query("select u from users u where u.dni = ?1")
	public User findByDni(String dni);
	
	@Query("select u from users u where u.lastName = ?1")
	public User findByLastName(String lastname);
	
	@Query("select u from users u where u.token = ?1")
	public User findByToken(String token);

	public User deleteByToken(User user);
	
	@Modifying
	@Transactional
	@Query("update users u set u.active = false  where u.token = ?1") 
	public void delete(String token);
}
