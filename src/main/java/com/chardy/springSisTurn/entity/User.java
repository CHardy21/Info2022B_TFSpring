package com.chardy.springSisTurn.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

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
	@Column(nullable=false, unique = true)
	private Long id;
	
	@Column(name="user_name", length =30)
	private String name;
	
	@Column(name="org_lastname", length =30)
	private String lastName;
	
	@Column(name="user_dni", length= 8,  unique = true)
	private String dni;
	
	@Column(name="user_phone", nullable = false)
	private Long phone;
	
	@Column(name="user_email", unique=true)
	@Email
	@NotBlank(message = "Debe ingresar un email válido.")
	private String email;
	
	@Column(name="user_create_date")
	@CreationTimestamp
    private LocalDateTime createDate;
	
	@Column(name="user_active", columnDefinition = "boolean default true")
	private Boolean active;
	
	@Column(name="user_token")
	private String token;
	
	/*
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	private Set<Turn> turns;
	*/
	
}
