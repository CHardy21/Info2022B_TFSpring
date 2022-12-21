package com.chardy.springSisTurn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chardy.springSisTurn.entity.Organization;


@Repository
public interface IOrganizationDao extends JpaRepository<Organization, Long> {
	
	public List<Organization> findAll();
	
	@Query("select u from organizations u where u.active = 1")
	public List<Organization> findByActive();

	@Query("select u from organizations u where u.cuit = ?1")
	public Organization findByCuit(String cuit);
	
	@Query("select u from organizations u where u.name = ?1")
	public Organization findByName(String name);
	
	@Query("select u from organizations u where u.token = ?1")
	public Organization findByToken(String token);
	

	
	
	//public OrganizationDto save(OrganizationDto organizationDto);
	
	//public Organization save(Organization organization);
	
	public Organization deleteByToken(Organization organization);
	
	@Modifying
	@Transactional
	@Query("update organizations u set u.active = false  where u.token = ?1") 
	public void delete(String token);
	

}
