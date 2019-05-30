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
@Table(name="Comentario")
@EntityListeners(AuditingEntityListener.class)

public class Comentario {
	
	//COLUMNAS DE LA TABLA COMENTARIO
	//DEFINICION
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_com;
	
	private long id_usu ;
	
	private long id_mot ;
	
	@NotBlank
	private String tex_com;
	
	
	//GETTERS AND SETTERS
	
	public long getId_com() {
		return id_com;
	}

	public void setId_com(long id_com) {
		this.id_com = id_com;
	}

	public long getId_usu() {
		return id_usu;
	}

	public void setId_usu(long id_usu) {
		this.id_usu = id_usu;
	}

	public long getId_mot() {
		return id_mot;
	}

	public void setId_mot(long id_mot) {
		this.id_mot = id_mot;
	}

	public String getTex_com() {
		return tex_com;
	}

	public void setTex_com(String tex_com) {
		this.tex_com = tex_com;
	}
	
}

