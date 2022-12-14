package com.chardy.springSisTurn.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//anotaciones para lombok
@Data
@AllArgsConstructor @NoArgsConstructor
//fin anotaciones para lombox

@Entity(name="users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String lastName;
	
	private Integer dni;
	
	private Boolean active;
	
	private String token;
	
	//private List<Turn> turns;

}
