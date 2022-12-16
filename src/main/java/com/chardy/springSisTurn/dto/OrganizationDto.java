package com.chardy.springSisTurn.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@SuppressWarnings("deprecation")
@Data
@AllArgsConstructor 
@NoArgsConstructor
@ToString

public class OrganizationDto  implements Serializable{

		
	@NotBlank(message = "El campo nombre no puede estar vacio")
	@Size(min = 4,  max= 30, message = "El nombre no debe ser menor a 4 caracteres y ni mayor a 30.")
	private String name;
	
	//@NotBlank(message = "El campo CUIT no puede ser nulo.")
	//@Size(min = 11,  max= 13, message = "Debe cargar los 11 digitos de su cuit.")
	private String cuit;
	
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
	
	
	@NotNull(message = "El campo nombre no puede estar vacio")
	@Size( min=1,max= 20, message = "El nombre no debe ser mayor a 20.")
	private String name;
	
	@NotNull(message="El campo cuit no puede ser nulo")
	@Size(min=10,max=11,message="El cuit no puede contener menos de 10 caracteres ni mas de 11.")
	private String cuit;
	
	@NotBlank(message = "El campo clave no puede estar vacio")
	@Size(min = 20, max = 40, message = "La clave no debe ser menor a 20 caracteres ni mayor a 40.")
	@Column(unique=true)
	private String clave;
	
	@Email(message = "El email no es valido")
	private String email;
	
	@NotBlank(message = "La direccion no puede estar vacia")
	private String direccion;
	
	*/
}
