package com.MotorbikeHome.SpringBootAPI.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.MotorbikeHome.SpringBootAPI.dao.MarcaDAO;
import com.MotorbikeHome.SpringBootAPI.model.Marca;

@RestController
@RequestMapping("/api")
public class MarcaController {
	
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
	MarcaDAO marcaDAO;
	
	//PARA GUARDAR UNA MARCA
	@PostMapping("/marca")
	public Marca createMarca(@Valid @RequestBody Marca mar) {
		return marcaDAO.save(mar);
	}
	
	
	//PARA OBTENER TODAS LAS MARCAS
	@GetMapping("/marca")
	public List<Marca> getAllMarca(){
		return marcaDAO.findAll();
	}
	
	
	//PARA OBTENER UNA MARCA POR ID
	@CrossOrigin
	@GetMapping("/marca/{id}")
	public ResponseEntity<Marca> getMarcaById(@PathVariable(value="id") Long id_mar) {
		
		Marca mar=marcaDAO.findOne(id_mar);
		
		if(mar==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(mar);
		
	}
	
	
	//PARA ACTUALIZAR UNA MARCA POR ID
	@CrossOrigin
	@PutMapping("/marca/{id}")
	public ResponseEntity<Marca> updateMarca(@PathVariable(value="id") Long id_mar,@Valid @RequestBody Marca marDetails) {
		
		Marca mar=marcaDAO.findOne(id_mar);
		
		if(mar==null) {
			return ResponseEntity.notFound().build();
		}
		
		mar.setNom_mar(marDetails.getNom_mar());
		mar.setInf_mar(marDetails.getInf_mar());
		
		Marca updateMarca=marcaDAO.save(mar);
		
		return ResponseEntity.ok().body(updateMarca);
		
	}
	
	
	//PARA ELIMINAR UNA MARCA POR ID
	@CrossOrigin
	@DeleteMapping("/marca/{id}")
	public ResponseEntity<Marca> deleteMarca(@PathVariable(value="id") Long id_mar) {
		
		Marca mar=marcaDAO.findOne(id_mar);
		
		if(mar==null) {
			return ResponseEntity.notFound().build();
		}
		
		marcaDAO.delete(mar);
		
		return ResponseEntity.ok().build();
		
	}
	
	

}

