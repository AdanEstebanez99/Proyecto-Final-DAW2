package com.MotorbikeHome.SpringBootAPI.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.MotorbikeHome.SpringBootAPI.dao.MotosFavoritasDAO;
import com.MotorbikeHome.SpringBootAPI.model.MotosFavoritas;
import com.MotorbikeHome.SpringBootAPI.model.motFavUsuKey;
import com.MotorbikeHome.SpringBootAPI.model.Usuario;
import com.MotorbikeHome.SpringBootAPI.repository.MotoRepository;
import com.MotorbikeHome.SpringBootAPI.repository.MotosFavoritasRepository;

@RestController
@RequestMapping("/api")
public class MotosFavoritasController {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/*").allowedOrigins("*");
			}
		};
	}
	
	@Autowired
	MotosFavoritasDAO motosFavoritasDAO;
	
	//PARA GUARDAR UNA MOTO FAVORITA
	@CrossOrigin
	@PostMapping("/motos/favoritas")
	public MotosFavoritas createMoto(@Valid @RequestBody motFavUsuKey motoFav) {
		MotosFavoritas nuevaMotFav = new MotosFavoritas();
		
		nuevaMotFav.setId(motoFav);
		
		return motosFavoritasDAO.save(nuevaMotFav);
	}
	
	//PARA ELIMINAR UNA MOTO FAVORITA
	@CrossOrigin
	@PostMapping("/motos/favoritas/delete")
	public ResponseEntity<MotosFavoritas> deleteMotoFav(@Valid @RequestBody motFavUsuKey motoFav) {
		MotosFavoritas eliminarMotFav = new MotosFavoritas();
		
		eliminarMotFav.setId(motoFav);
		
		motosFavoritasDAO.delete(eliminarMotFav);
		
		return ResponseEntity.ok().build();
	}
	
	
	//PARA OBTENER TODAS LAS MOTOS FAVORITAS
	@GetMapping("/motos/favoritas")
	public List<MotosFavoritas> getAllMotosFav(){
		return motosFavoritasDAO.findAll();
	}
	
	
	//PARA OBTENER EL ID DE LAS MOTOS DE CADA USUARIO
	@CrossOrigin
	@PostMapping("/motos/favoritasId")
	public ArrayList<Long> getIdMotosByUsu(@Valid @RequestBody Long idUsu) {
		
		List<MotosFavoritas> allMotos = getAllMotosFav();
		
		ArrayList<Long> respuesta = new ArrayList();
			
		for (int x = 0; x < allMotos.size(); x ++) {
			long id_usu = allMotos.get(x).getId().getId_usu();
			
				
			if (id_usu == idUsu) {
				
				long id_mot = allMotos.get(x).getId().getId_prod();
				respuesta.add(id_mot);
				
			} else {
				
			}
				
		}
		
		return respuesta;
		
		
	}
		
	
	//PARA OBTENER UNA MOTO FAVORITA POR ID
	@CrossOrigin
	@GetMapping("/motos/favoritas/{id}")
	public ResponseEntity<MotosFavoritas> getMotoFavoritaById(@PathVariable(value="id") Long id_mot) {
		
		MotosFavoritas motFav=motosFavoritasDAO.findOne(id_mot);
		
		if(motFav==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(motFav);
		
	}
	
	
	//PARA ELIMINAR UNA MOTO FAVORITA POR ID
	@CrossOrigin
	@DeleteMapping("/motos/favoritas/{id}")
	public ResponseEntity<MotosFavoritas> deleteMoto(@PathVariable(value="id") Long id_mot) {
		
		MotosFavoritas motFav=motosFavoritasDAO.findOne(id_mot);
		
		if(motFav==null) {
			return ResponseEntity.notFound().build();
		}
		
		motosFavoritasDAO.delete(motFav);
		
		return ResponseEntity.ok().build();
		
	}
	
	

}
