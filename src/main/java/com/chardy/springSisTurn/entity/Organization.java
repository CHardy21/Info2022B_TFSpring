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


//@Data
//@AllArgsConstructor @NoArgsConstructor
//@ToString

@Entity(name="organizations")
public class Organization implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false, unique = true)
	private Long id;

	@Column(name="org_name", length =30, unique = true)
	private String name;
	
	@Column(name="org_cuit", length= 13)
	private String cuit;
	
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
	
	//@JsonIgnore
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "organization_id")
	private Set<Event> events;

	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organization(Long id, String name, String cuit, String address, Long phone,
			@Email @NotBlank(message = "Debe ingresar un email.") String email, Boolean active,
			LocalDateTime createDate, String token, Set<Event> events) {
		super();
		this.id = id;
		this.name = name;
		this.cuit = cuit;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.active = active;
		this.createDate = createDate;
		this.token = token;
		this.events = events;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	
	
	
}
