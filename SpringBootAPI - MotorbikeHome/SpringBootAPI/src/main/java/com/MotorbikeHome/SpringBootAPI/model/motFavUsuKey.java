package com.MotorbikeHome.SpringBootAPI.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class motFavUsuKey implements Serializable {
	
	@Column(name = "id_prod")
	Long id_prod;
	
	@Column(name = "id_usu")
	Long id_usu;

	
	// GETTERS AND SETTERS
	public Long getId_prod() {
		return id_prod;
	}

	public void setId_prod(Long id_prod) {
		this.id_prod = id_prod;
	}

	public Long getId_usu() {
		return id_usu;
	}

	public void setId_usu(Long id_usu) {
		this.id_usu = id_usu;
	}
	
	
}
