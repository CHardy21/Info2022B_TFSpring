package com.chardy.springSisTurn.service;

import java.util.List;

import com.chardy.springSisTurn.entity.Organization;


public interface IOrganizationService {

	public List<Organization> getAll();
	public List<Organization> getAllActive();
	
}
