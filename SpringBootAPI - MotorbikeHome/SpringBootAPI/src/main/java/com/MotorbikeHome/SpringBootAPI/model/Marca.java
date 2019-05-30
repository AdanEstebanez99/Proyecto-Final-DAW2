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
@Table(name="Marca")
@EntityListeners(AuditingEntityListener.class)

public class Marca {
	
	//COLUMNAS DE LA TABLA MARCA
	//DEFINICION
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_mar;
	
	@NotBlank
	private String nom_mar ;
	
	@NotBlank
	private String inf_mar;
	
	
	//GETTERS AND SETTERS
	public long getId_mar() {
		return id_mar;
	}

	public void setId_mar(long id_mar) {
		this.id_mar = id_mar;
	}

	public String getNom_mar() {
		return nom_mar;
	}

	public void setNom_mar(String nom_mar) {
		this.nom_mar = nom_mar;
	}

	public String getInf_mar() {
		return inf_mar;
	}

	public void setInf_mar(String inf_mar) {
		this.inf_mar = inf_mar;
	}

}
