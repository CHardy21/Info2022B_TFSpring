package com.chardy.springSisTurn.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class EventDTO {
	
	@NotBlank(message = "El campo Nombre no puede estar vacio")
	@Size(min = 4,  max= 30, message = "El Nombre no debe ser menor a 4 caracteres, ni mayor a 30.")
	private String name;
	
	@NotBlank(message = "El lugar del Evento no puede ser nulo.")
	private String location;
	
	@Column(name="event_type", columnDefinition = "boolean default false")
	@NotBlank(message = "El Tipo de Evento no puede ser nulo. Use '0' para Evento único ó '1' para Evento recurrente")
	private Boolean type;	 
	
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
	private LocalDateTime dateInit; 
		
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
	private LocalDateTime dateFinish;
	
	
}
