package com.MotorbikeHome.SpringBootAPI.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MotorbikeHome.SpringBootAPI.model.Modalidad;
import com.MotorbikeHome.SpringBootAPI.repository.ModalidadRepository;

@Service
public class ModalidadDAO {
	
	@Autowired
	ModalidadRepository modalidadRepository;
	
	
	//GUARDAR MODALIDADES
	public Modalidad save(Modalidad mod) {
		return modalidadRepository.save(mod);
	}
	
	
	//BUSCAR TODAS LAS MODALIDADES
	public List<Modalidad> findAll(){
		return modalidadRepository.findAll();
	}
	
	
	//OBTENER UNA MODALIDAD POR ID
	public Modalidad findOne(Long id_mod) {
		return modalidadRepository.findOne(id_mod);
	}
	
	
	//ELIMINAR UNA MODALIDAD
	public void delete (Modalidad mod) {
		modalidadRepository.delete(mod);
	}
	
}

