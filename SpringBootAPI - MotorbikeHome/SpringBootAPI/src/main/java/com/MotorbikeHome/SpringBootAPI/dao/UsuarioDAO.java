package com.MotorbikeHome.SpringBootAPI.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MotorbikeHome.SpringBootAPI.model.Usuario;
import com.MotorbikeHome.SpringBootAPI.repository.UsuarioRepository;

@Service
public class UsuarioDAO {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	//GUARDAR USUARIOS
	public Usuario save(Usuario usu) {
		return usuarioRepository.save(usu);
	}
	
	
	//BUSCAR TODAS LOS USUARIOS
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	
	//OBTENER UN USUARIO POR ID
	public Usuario findOne(Long id_usu) {
		return usuarioRepository.findOne(id_usu);
	}
	
	
	//ELIMINAR UN USUARIO
	public void delete (Usuario usu) {
		usuarioRepository.delete(usu);
	}
	
}
