package com.chardy.springSisTurn.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor @NoArgsConstructor

@Entity(name="turns")
public class Turn implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="turn_name")
	private String name;
	
	@Column(name="turn_code")
	private String code;
	
	@Column(name="turn_date")
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
	private LocalDateTime dateTurn;
	
	@Column(name="turn_active")
	private Boolean active;
	
	
	
	
	
	
	
}
