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

import com.MotorbikeHome.SpringBootAPI.dao.ModalidadDAO;
import com.MotorbikeHome.SpringBootAPI.model.Modalidad;

@RestController
@RequestMapping("/api")
public class ModalidadController {
	
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
	ModalidadDAO modalidadDAO;
	
	//PARA GUARDAR UNA MODALIDAD
	@PostMapping("/modalidad")
	public Modalidad createModalidad(@Valid @RequestBody Modalidad mod) {
		return modalidadDAO.save(mod);
	}
	
	
	//PARA OBTENER TODAS LAS MODALIDADES
	@GetMapping("/modalidad")
	public List<Modalidad> getAllModalidad(){
		return modalidadDAO.findAll();
	}
	
	
	//PARA OBTENER UNA MODALIDAD POR ID
	@CrossOrigin
	@GetMapping("/modalidad/{id}")
	public ResponseEntity<Modalidad> getModalidadById(@PathVariable(value="id") Long id_mod) {
		
		Modalidad mod=modalidadDAO.findOne(id_mod);
		
		if(mod==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(mod);
		
	}
	
	
	//PARA ACTUALIZAR UNA MODALIDAD POR ID
	@CrossOrigin
	@PutMapping("/modalidad/{id}")
	public ResponseEntity<Modalidad> updateModalidad(@PathVariable(value="id") Long id_mod,@Valid @RequestBody Modalidad modDetails) {
		
		Modalidad mod=modalidadDAO.findOne(id_mod);
		
		if(mod==null) {
			return ResponseEntity.notFound().build();
		}
		
		mod.setNom_mod(modDetails.getNom_mod());
		
		Modalidad updateModalidad=modalidadDAO.save(mod);
		
		return ResponseEntity.ok().body(updateModalidad);
		
	}
	
	
	//PARA ELIMINAR UNA MODALIDAD POR ID
	@CrossOrigin
	@DeleteMapping("/modalidad/{id}")
	public ResponseEntity<Modalidad> deleteModalidad(@PathVariable(value="id") Long id_mod) {
		
		Modalidad mod=modalidadDAO.findOne(id_mod);
		
		if(mod==null) {
			return ResponseEntity.notFound().build();
		}
		
		modalidadDAO.delete(mod);
		
		return ResponseEntity.ok().build();
		
	}
	

}
