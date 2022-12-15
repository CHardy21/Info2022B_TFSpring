package com.chardy.springSisTurn.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor @NoArgsConstructor


public class OrganizationDto {

	private Long id;
	@NotBlank(message = "El campo nombre no puede estar vacio")
	@Size(min = 4,  max= 30, message = "El nombre no debe ser menor a 4 caracteres y ni mayor a 30.")
	private String name;
	
	//@NotBlank(message = "El campo CUIT no puede ser nulo.")
	//@Size(min = 11,  max= 11, message = "debe cargar los 11 digitos de su cuit.")
	private Long cuit;
	
	@NotBlank(message = "La direccion no puede ser nulo.")
	private String address;
	
	//@NotBlank(message = "El número de telefono no puede ser nulo.")
	private Long phone;
	
	
	//@Email
	//@NotBlank(message = "Debe ingresar un email.")
	private String email;
	/*
	private Boolean active;
	
    private LocalDateTime createDate;
	
	private String token;
	
	private Set<Event> events;
	*/
	
}
