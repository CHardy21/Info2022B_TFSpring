package com.chardy.springSisTurn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.repository.IOrganizationDao;



@Service
public class OrganizationServiceImpl implements IOrganizationService{

	@Autowired
	private IOrganizationDao organizationDao;
	
	@Override
	public List<Organization> getAll() {
		return organizationDao.findAll();
	}

}
