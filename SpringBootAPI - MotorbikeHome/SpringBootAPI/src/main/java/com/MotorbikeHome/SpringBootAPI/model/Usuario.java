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
@Table(name="Usuario")
@EntityListeners(AuditingEntityListener.class)

public class Usuario {
	
	//COLUMNAS DE LA TABLA USUARIO
	//DEFINICION
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_usu;
	
	@NotBlank
	private String nick_usu ;
	
	@NotBlank
	private String nom_usu;
	
	@NotBlank
	private String ape_usu;
	
	@NotBlank
	private String con_usu;
	
	@NotBlank
	private String cor_usu;
	
	@NotBlank
	private String col_usu;
	
	private int rol_usu;
	
	private String img_usu;
	
	
	//GETTERS AND SETTERS
	public long getId_usu() {
		return id_usu;
	}

	public void setId_usu(long id_usu) {
		this.id_usu = id_usu;
	}

	public String getNick_usu() {
		return nick_usu;
	}

	public void setNick_usu(String nick_usu) {
		this.nick_usu = nick_usu;
	}

	public String getNom_usu() {
		return nom_usu;
	}

	public void setNom_usu(String nom_usu) {
		this.nom_usu = nom_usu;
	}

	public String getApe_usu() {
		return ape_usu;
	}

	public void setApe_usu(String ape_usu) {
		this.ape_usu = ape_usu;
	}

	public String getCon_usu() {
		return con_usu;
	}

	public void setCon_usu(String con_usu) {
		this.con_usu = con_usu;
	}

	public String getCor_usu() {
		return cor_usu;
	}

	public void setCor_usu(String cor_usu) {
		this.cor_usu = cor_usu;
	}

	public String getCol_usu() {
		return col_usu;
	}

	public void setCol_usu(String col_usu) {
		this.col_usu = col_usu;
	}
	public int getRol_usu() {
		return rol_usu;
	}

	public void setRol_usu(int rol_usu) {
		this.rol_usu = rol_usu;
	}

	public String getImg_usu() {
		return img_usu;
	}

	public void setImg_usu(String img_usu) {
		this.img_usu = img_usu;
	}
	
	
	
}

