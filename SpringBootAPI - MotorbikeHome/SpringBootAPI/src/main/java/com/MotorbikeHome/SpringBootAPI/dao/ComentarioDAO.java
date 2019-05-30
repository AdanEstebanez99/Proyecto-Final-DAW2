package com.MotorbikeHome.SpringBootAPI.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MotorbikeHome.SpringBootAPI.model.Comentario;
import com.MotorbikeHome.SpringBootAPI.repository.ComentarioRepository;

@Service
public class ComentarioDAO {
	
	@Autowired
	ComentarioRepository comentarioRepository;
	
	
	//GUARDAR COMENTARIOS
	public Comentario save(Comentario coment) {
		return comentarioRepository.save(coment);
	}
	
	
	//BUSCAR TODOS LOS COMENTARIOS
	public List<Comentario> findAll(){
		return comentarioRepository.findAll();
	}
	
	
	//OBTENER UN COMENTARIO POR ID
	public Comentario findOne(Long id_com) {
		return comentarioRepository.findOne(id_com);
	}
	
	
	//ELIMINAR UN COMENTARIO
	public void delete (Comentario coment) {
		comentarioRepository.delete(coment);
	}
	
}

