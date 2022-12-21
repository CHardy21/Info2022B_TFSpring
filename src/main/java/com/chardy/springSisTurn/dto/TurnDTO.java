package com.chardy.springSisTurn.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor @NoArgsConstructor
@ToString

public class TurnDTO {
	
	@NotBlank(message = "El campo Nombre no puede estar vacio")
	@Size(min = 4,  max= 30, message = "El Nombre no debe ser menor a 4 caracteres, ni mayor a 30.")
	private String nameEvent;
	
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
	private LocalDateTime dateTurn;
	
	private Long idEvent;
	
	

}
