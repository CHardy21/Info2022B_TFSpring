package com.chardy.springSisTurn.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor @NoArgsConstructor


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
	
	@Column(name="event_date_init", nullable = false) //
	//@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")  //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") Date myDate 
	private LocalDateTime dateInit; 
		
	@Column(name="event_date_finish")
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
	private LocalDateTime dateFin;
	
	@Column(name="event_active", columnDefinition = "boolean default true")
	private Boolean active;
	
	@Column(name="event_create_date", updatable = false)
	@CreationTimestamp
    private LocalDateTime creationDate; 
		
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "events_id")
	private Set<Turn> turns;
	
	
	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JoinTable(name="organizations")
	//@JoinColumn(name = "organizations_id")
	//private Organization organization;
	// organization_id se agrega a la tabla por relacion en Organization entity

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(	foreignKey = @ForeignKey(name = "fk_events_organizations_id"), 
					name="organizations_id", 
					referencedColumnName = "id", 
					columnDefinition = "int"
				  )
    private Organization organization;

}
