package com.chardy.springSisTurn.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor

@Entity(name="users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_name", length =30)
	private String name;
	
	@Column(name="org_lastname", length =30)
	private String lastName;
	
	@Column(name="user_dni", length= 8,  unique = true)
	private Integer dni;
	
	@Column(name="userg_active", columnDefinition = "boolean default true")
	private Boolean active;
	
	@Column(name="user_token")
	private String token;
	
	/*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private Set<Turn> turns;
	*/
	
}
