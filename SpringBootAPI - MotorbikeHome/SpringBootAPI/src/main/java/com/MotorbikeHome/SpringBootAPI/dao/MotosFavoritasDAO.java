package com.MotorbikeHome.SpringBootAPI.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MotorbikeHome.SpringBootAPI.model.MotosFavoritas;
import com.MotorbikeHome.SpringBootAPI.repository.MotosFavoritasRepository;

@Service
public class MotosFavoritasDAO {
	
	@Autowired
	MotosFavoritasRepository motosFavoritasRepository;
	
	
	//GUARDAR NUEVA MOTO FAVORITA
	public MotosFavoritas save(MotosFavoritas motFav) {
		return motosFavoritasRepository.save(motFav);
	}

	
	//BUSCAR TODAS LAS MOTOS FAVORITAS
	public List<MotosFavoritas> findAll(){
		return motosFavoritasRepository.findAll();
	}
	
	
	//OBTENER UNA MOTO FAVORITA POR ID
	public MotosFavoritas findOne(Long id_mot) {
		return motosFavoritasRepository.findOne(id_mot);
	}
	
	
	//ELIMINAR UNA MOTO DE FAVORITOS
	public void delete (MotosFavoritas motFav) {
		motosFavoritasRepository.delete(motFav);
	}

	
}

