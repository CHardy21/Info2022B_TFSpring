package com.chardy.springSisTurn.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@ToString

public class UserDTO {
	
	@NotBlank(message = "El campo Nombre no puede estar vacio")
	@Size(min = 4,  max= 30, message = "El Nombre no debe ser menor a 4 caracteres, ni mayor a 30.")
	private String name;
	
	@NotBlank(message = "El campo Apellido no puede estar vacio")
	@Size(min = 4,  max= 30, message = "El Apellido no debe ser menor a 4 caracteres, ni mayor a 30.")
	private String lastName;
	
	@NotBlank(message = "El campo DNI no puede ser nulo.")
	@Size(min = 7,  max= 8, message = "Debe cargar todos los digitos de su DNI (sin puntos).")
	private String dni;

	@NotBlank(message = "El número de telefono no puede ser nulo.")
	private Long phone;
	
	@Email
	@NotBlank(message = "Debe ingresar un email válido.")
	private String email;

}
