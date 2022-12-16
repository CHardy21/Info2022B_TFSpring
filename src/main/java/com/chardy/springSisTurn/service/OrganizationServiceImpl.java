package com.chardy.springSisTurn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chardy.springSisTurn.dto.OrganizationDto;
import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.repository.IOrganizationDao;
import com.chardy.springSisTurn.wrapper.OrganizationWrapper;




@Service
public class OrganizationServiceImpl implements IOrganizationService{

	@Autowired
	private IOrganizationDao organizationDao;
	
	@Override
	public List<Organization> getAll() {
		return organizationDao.findAll();
	}

	@Override
	public List<Organization> getAllActive() {
		return organizationDao.findByActive();
	}
	
	@Override
	public Organization findByCuit(String cuit) {
		return organizationDao.findByCuit(cuit);
	}
	
	@Override
	public Organization findByName(String name) {
		// TODO Apéndice de método generado automáticamente
		return organizationDao.findByName(name);
	}

	@Override
	public OrganizationDto save(OrganizationDto organizationDto) {
		Organization organization = OrganizationWrapper.dtoToEntity(organizationDto);
		organization = organizationDao.save(organization);
		organizationDto = OrganizationWrapper.entityToDto(organization);
		return organizationDto;
	}




	


}
