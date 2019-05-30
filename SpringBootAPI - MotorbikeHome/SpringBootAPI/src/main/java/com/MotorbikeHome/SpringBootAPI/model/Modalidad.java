package com.MotorbikeHome.SpringBootAPI.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="Modalidad")
@EntityListeners(AuditingEntityListener.class)

public class Modalidad {
	
	//COLUMNAS DE LA TABLA MODALIDAD
	//DEFINICION
	
	@NotBlank
	private String nom_mod ;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_mod;
	
	
	//GETTERS AND SETTERS
	public String getNom_mod() {
		return nom_mod;
	}

	public void setNom_mod(String nom_mod) {
		this.nom_mod = nom_mod;
	}

	public long getId_mod() {
		return id_mod;
	}

	public void setId_mod(long id_mod) {
		this.id_mod = id_mod;
	}
}

