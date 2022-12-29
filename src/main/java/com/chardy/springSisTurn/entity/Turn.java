package com.chardy.springSisTurn.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data
//@AllArgsConstructor @NoArgsConstructor

@Entity(name="turns")
public class Turn implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="turn_event_name")
	private String nameEvent;
	
	@Column(name="turn_code",unique=true, nullable = false)
	private String code = cadenaAleatoria(20);
	
	@Column(name="turn_date")
	@Future
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
	private LocalDateTime dateTurn;
	
	@Column(name="turn_active")
	private Boolean active;
	
	@Column(name="turn_create_date")
	@CreationTimestamp
    private LocalDateTime createDate;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
	private Event event;
	
	
    public static String cadenaAleatoria(int longitud) {
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }
    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
	public Turn(Long id, String nameEvent, String code, @Future LocalDateTime dateTurn, Boolean active,
			LocalDateTime createDate, User user, Event event) {
		super();
		this.id = id;
		this.nameEvent = nameEvent;
		this.code = code;
		this.dateTurn = dateTurn;
		this.active = active;
		this.createDate = createDate;
		this.user = user;
		this.event = event;
	}
	public Turn() {
		super();
		// TODO Apéndice de constructor generado automáticamente
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameEvent() {
		return nameEvent;
	}
	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public LocalDateTime getDateTurn() {
		return dateTurn;
	}
	public void setDateTurn(LocalDateTime dateTurn) {
		this.dateTurn = dateTurn;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	
}
