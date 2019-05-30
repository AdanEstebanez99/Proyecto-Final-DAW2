package com.MotorbikeHome.SpringBootAPI.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="usu_prod_fav")
@EntityListeners(AuditingEntityListener.class)

public class MotosFavoritas {
	
	//COLUMNAS DE LA TABLA USU_PROD_FAV
	//DEFINICION
	
	@EmbeddedId
	motFavUsuKey id;

	
	//GETTERS AND SETTERS
	
	public motFavUsuKey getId() {
		return id;
	}



	public void setId(motFavUsuKey id) {
		this.id = id;
	}
	

}
