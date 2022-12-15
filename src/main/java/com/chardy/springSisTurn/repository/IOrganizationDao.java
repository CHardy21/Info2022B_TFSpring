package com.chardy.springSisTurn.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chardy.springSisTurn.dto.OrganizationDto;
import com.chardy.springSisTurn.entity.Organization;


@Repository
public interface IOrganizationDao extends JpaRepository<Organization, Long> {
	
	public List<Organization> findAll();
	
	@Query("select u from organizations u where u.active = 1")
	public List<Organization> findByActive();

	public OrganizationDto save(OrganizationDto organizationDto);
	

}
