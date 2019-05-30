package com.MotorbikeHome.SpringBootAPI.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MotorbikeHome.SpringBootAPI.model.Marca;
import com.MotorbikeHome.SpringBootAPI.repository.MarcaRepository;

@Service
public class MarcaDAO {
	
	@Autowired
	MarcaRepository marcaRepository;
	
	
	//GUARDAR MARCAS
	public Marca save(Marca mar) {
		return marcaRepository.save(mar);
	}
	
	
	//BUSCAR TODAS LAS MARCAS
	public List<Marca> findAll(){
		return marcaRepository.findAll();
	}
	
	
	//OBTENER UNA MARCA POR ID
	public Marca findOne(Long id_mar) {
		return marcaRepository.findOne(id_mar);
	}
	
	
	//ELIMINAR UNA MARCA
	public void delete (Marca mar) {
		marcaRepository.delete(mar);
	}
	
}

