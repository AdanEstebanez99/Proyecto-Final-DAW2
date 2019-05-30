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
@Table(name="Motos")
@EntityListeners(AuditingEntityListener.class)

public class Moto {
	
	//COLUMNAS DE LA TABLA MOTOS
	//DEFINICION
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_mot;
	
	
	private long id_mar;
	
	
	private long id_mod;
	
	@NotBlank
	private String nom_mot ;
	
	@NotBlank
	private String img_mot;
	
	@NotBlank
	private String cil_mot;
	
	@NotBlank
	private String cic_mot;
	
	@NotBlank
	private String ref_mot;
	
	@NotBlank
	private String trn_mot;
	
	@NotBlank
	private String nmar_mot;
	
	@NotBlank
	private String cha_mot;
	
	@NotBlank
	private String frd_mot;
	
	@NotBlank
	private String frt_mot;
	
	@NotBlank
	private String rud_mot;
	
	@NotBlank
	private String rut_mot;
	
	@NotBlank
	private String pes_mot;
	
	
	//GETTERS AND SETTERS

	public String getCic_mot() {
		return cic_mot;
	}

	public void setCic_mot(String cic_mot) {
		this.cic_mot = cic_mot;
	}

	public String getRef_mot() {
		return ref_mot;
	}

	public void setRef_mot(String ref_mot) {
		this.ref_mot = ref_mot;
	}

	public String getTrn_mot() {
		return trn_mot;
	}

	public void setTrn_mot(String trn_mot) {
		this.trn_mot = trn_mot;
	}

	public String getNmar_mot() {
		return nmar_mot;
	}

	public void setNmar_mot(String nmar_mot) {
		this.nmar_mot = nmar_mot;
	}

	public String getCha_mot() {
		return cha_mot;
	}

	public void setCha_mot(String cha_mot) {
		this.cha_mot = cha_mot;
	}

	public String getFrd_mot() {
		return frd_mot;
	}

	public void setFrd_mot(String frd_mot) {
		this.frd_mot = frd_mot;
	}

	public String getFrt_mot() {
		return frt_mot;
	}

	public void setFrt_mot(String frt_mot) {
		this.frt_mot = frt_mot;
	}

	public String getRud_mot() {
		return rud_mot;
	}

	public void setRud_mot(String rud_mot) {
		this.rud_mot = rud_mot;
	}

	public String getRut_mot() {
		return rut_mot;
	}

	public void setRut_mot(String rut_mot) {
		this.rut_mot = rut_mot;
	}

	public String getPes_mot() {
		return pes_mot;
	}

	public void setPes_mot(String pes_mot) {
		this.pes_mot = pes_mot;
	}

	public long getId_mot() {
		return id_mot;
	}

	public void setId_mot(long id_mot) {
		this.id_mot = id_mot;
	}

	public long getId_mar() {
		return id_mar;
	}

	public void setId_mar(long id_mar) {
		this.id_mar = id_mar;
	}

	public long getId_mod() {
		return id_mod;
	}

	public void setId_mod(long id_mod) {
		this.id_mod = id_mod;
	}

	public String getNom_mot() {
		return nom_mot;
	}

	public void setNom_mot(String nom_mot) {
		this.nom_mot = nom_mot;
	}

	public String getCil_mot() {
		return cil_mot;
	}

	public void setCil_mot(String cil_mot) {
		this.cil_mot = cil_mot;
	}

	public String getImg_mot() {
		return img_mot;
	}

	public void setImg_mot(String img_mot) {
		this.img_mot = img_mot;
	}



}
