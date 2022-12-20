package com.chardy.springSisTurn.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@ToString

public class EventDTO {
	
	@NotBlank(message = "El campo Nombre no puede estar vacio")
	@Size(min = 4,  max= 30, message = "El Nombre no debe ser menor a 4 caracteres, ni mayor a 30.")
	private String name;
	
	@NotBlank(message = "El lugar del Evento no puede ser nulo.")
	private String location;
	
	@Column(name="event_type", columnDefinition = "boolean default false")
	//@NotBlank(message = "El Tipo de Evento no puede ser nulo. Use '0' para Evento único ó '1' para Evento recurrente")
	@NotNull(message = "Debe seleccionar uno tipo de Evento. Use '0' para Evento único ó '1' para Evento recurrente")
	private Boolean type;	 
	
	@Future(message="Debe ingresar una fecha Futura")
	//@DateTimeFormat(pattern="dd-MM-yyyy")
	@JsonFormat(pattern="dd-MM-yyyy HH:mm")
	private LocalDateTime dateInit; 
		
	@JsonFormat(pattern="dd-MM-yyyy HH:mm")
	private LocalDateTime dateFin;
	
	
}
