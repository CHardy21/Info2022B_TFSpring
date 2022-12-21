package com.chardy.springSisTurn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chardy.springSisTurn.dto.OrganizationDto;
import com.chardy.springSisTurn.entity.Event;
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
	/*
	@Override
	public List<Event> findAllEvents(Long id) {
		return organizationDao.findAllEvents(id);
	}
	*/
	@Override
	public Organization findByCuit(String cuit) {
		return organizationDao.findByCuit(cuit);
	}
	
	@Override
	public Organization findByName(String name) {
		return organizationDao.findByName(name);
	}

	@Override
	public Organization findByToken(String token) {
		return organizationDao.findByToken(token);
	}
	
	@Override
	public OrganizationDto save(OrganizationDto organizationDto) {
		
		Organization organization = OrganizationWrapper.dtoToEntity(organizationDto);
		
		// Code to generate token
		organization.setActive(true);
		organization.setToken("token"+organization.getName()+organization.getEmail());
		
		organization = organizationDao.save(organization);
		organizationDto = OrganizationWrapper.entityToDto(organization);
		return organizationDto;
	}

	@Override
	public Organization delete(Organization organizacion) {
		
		String token = organizacion.getToken();
		
		Organization deleteOrg = organizationDao.findByToken(organizacion.getToken());
			if(deleteOrg != null) {
				deleteOrg.setActive(false);
				organizationDao.delete(token);
			return deleteOrg;
		}
		return deleteOrg;
	}

	@Override
	public OrganizationDto update(OrganizationDto organizacion, String token) {
		
		Organization existOrg = organizationDao.findByToken(token);
		Organization newUpdateOrg = OrganizationWrapper.dtoToEntity(organizacion);
		
		//existOrg.setName(token);
		newUpdateOrg.setId(existOrg.getId());
		newUpdateOrg.setActive(existOrg.getActive());
		newUpdateOrg.setCreateDate(existOrg.getCreateDate());
		newUpdateOrg.setEvents(existOrg.getEvents());
		newUpdateOrg.setToken(token);
		
		Organization updateOrg = organizationDao.save(newUpdateOrg);
		
			if(updateOrg != null) {
				OrganizationDto updateOrgDto = OrganizationWrapper.entityToDto(updateOrg);
			return updateOrgDto;
		}
		
		return null;
	}

	@Override
	public Organization save(Organization organization) {
		// TODO Auto-generated method stub
		return null;
	}








		

}
