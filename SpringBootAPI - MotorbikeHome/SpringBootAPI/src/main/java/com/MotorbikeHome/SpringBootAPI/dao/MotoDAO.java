package com.MotorbikeHome.SpringBootAPI.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MotorbikeHome.SpringBootAPI.model.Moto;
import com.MotorbikeHome.SpringBootAPI.repository.MotoRepository;

@Service
public class MotoDAO {
	
	@Autowired
	MotoRepository motoRepository;
	
	
	//GUARDAR MOTOS
	public Moto save(Moto mot) {
		return motoRepository.save(mot);
	}
	
	
	//BUSCAR TODAS LAS MOTOS
	public List<Moto> findAll(){
		return motoRepository.findAll();
	}
	
	
	//OBTENER UNA MOTO POR ID
	public Moto findOne(Long id_mot) {
		return motoRepository.findOne(id_mot);
	}
	
	
	//ELIMINAR UNA MOTO
	public void delete (Moto mot) {
		motoRepository.delete(mot);
	}
	
}
