package com.chardy.springSisTurn.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



// anotaciones para lombok
@Data
@AllArgsConstructor @NoArgsConstructor
// fin anotaciones para lombox

@Entity(name="organizations")
public class Organization implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@ManyToOne
    //@Column(name = "user_id")
    //private User userOrganization;
	
	//@Column(name="org_type")
	//private Boolean orgType;   // true = empresa | false= unipersonal
	
	@Column(name="org_name", length =30, unique = true)
	private String name;
	
	@Column(name="org_cuit", length= 11)
	private Long cuit;
	
	@Column(name="org_address")
	private String address;
	
	@Column(name="org_phone", nullable = false)
	private Long phone;
	
	@Column(name="org_email", unique=true)
	@Email
	@NotBlank(message = "Debe ingresar un email.")
	private String email;
	
	@Column(name="org_active", columnDefinition = "boolean default true")
	private Boolean active;
	
	@Column(name="org_create_date")
	@CreationTimestamp
    private LocalDateTime createDate;
	
	@Column(name="org_token")
	private String token;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "organizations_id")
	private Set<Event> events;
	
}
