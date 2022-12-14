package com.chardy.springSisTurn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chardy.springSisTurn.entity.Organization;


@Repository
public interface IOrganizationDao extends JpaRepository<Organization, Long> {
	
	public List<Organization> findAll();
	
	public List<Organization> findByActive();
	

}
