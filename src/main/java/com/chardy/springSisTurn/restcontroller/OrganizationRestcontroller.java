package com.chardy.springSisTurn.restcontroller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.repository.IOrganizationDao;

@RestController
public class OrganizationRestcontroller {
	private Logger log = LoggerFactory.getLogger(OrganizationRestcontroller.class);
	@Autowired
	private IOrganizationDao organizationService;
	
	@GetMapping("/organizations/all")
	public ResponseEntity<HashMap<String, Object>> todasLasOrganizaciones() {
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		List<Organization> organizaciones = organizationService.findAll();
		response.put("organizations", organizaciones);		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
}
