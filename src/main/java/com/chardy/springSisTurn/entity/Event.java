package com.chardy.springSisTurn.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;


//@Data
//@AllArgsConstructor @NoArgsConstructor


@Entity(name="events")
public class Event implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="event_name", length =30)
	private String name;
	
	@Column(name="event_location", length =30)
	private String location;
	
	@Column(name="event_type",  nullable = false)
	private Boolean type;	 // 0 = Evento unico | 1 = evento recurrente
	
	@Column(name="event_date_init", nullable = false)
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
	private LocalDateTime dateInit; 
		
	@Column(name="event_date_finish")
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
	private LocalDateTime dateFin;
	
	@Column(name="event_active", columnDefinition = "boolean default true")
	private Boolean active;
	
	@Column(name="event_create_date", updatable = false)
	@CreationTimestamp
    private LocalDateTime creationDate; 
	
	@JsonIgnore
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "event_id")
	private Set<Turn> turns;
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Organization organization;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(Long id, String name, String location, Boolean type, LocalDateTime dateInit, LocalDateTime dateFin,
			Boolean active, LocalDateTime creationDate, Set<Turn> turns, Organization organization) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.type = type;
		this.dateInit = dateInit;
		this.dateFin = dateFin;
		this.active = active;
		this.creationDate = creationDate;
		this.turns = turns;
		this.organization = organization;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public LocalDateTime getDateInit() {
		return dateInit;
	}

	public void setDateInit(LocalDateTime dateInit) {
		this.dateInit = dateInit;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Set<Turn> getTurns() {
		return turns;
	}

	public void setTurns(Set<Turn> turns) {
		this.turns = turns;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", location=" + location + ", type=" + type + ", dateInit="
				+ dateInit + ", dateFin=" + dateFin + ", active=" + active + ", creationDate=" + creationDate
				+ ", turns=" + turns + ", organization=" + organization + "]";
	}

	
	
	
}
