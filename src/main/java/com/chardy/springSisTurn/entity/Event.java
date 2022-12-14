package com.chardy.springSisTurn.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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

@Entity(name="events")
public class Event implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String eventName;
	
	private String eventLocation;
	
	private Boolean eventActive;
	
	@CreationTimestamp
    private LocalDateTime creationDate; 
	
        
	
}
