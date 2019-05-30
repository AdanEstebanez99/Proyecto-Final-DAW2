package com.MotorbikeHome.SpringBootAPI.controller;

import java.util.ArrayList;
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

import com.MotorbikeHome.SpringBootAPI.dao.MotoDAO;
import com.MotorbikeHome.SpringBootAPI.model.Moto;
import com.MotorbikeHome.SpringBootAPI.model.Usuario;

@RestController
@RequestMapping("/api")
public class MotoController {
	
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
	MotoDAO motoDAO;
	
	//PARA GUARDAR UNA MOTO
	@PostMapping("/motos")
	public Moto createMoto(@Valid @RequestBody Moto mot) {
		return motoDAO.save(mot);
	}
	
	
	//PARA OBTENER TODAS LAS MOTOS
	@GetMapping("/motos")
	public List<Moto> getAllMotos(){
		return motoDAO.findAll();
	}
	
	
	//PARA OBTENER TODAS LAS MOTOS FAVORITAS
	@CrossOrigin
	@PostMapping("/motos/favoritas/detalles")
	public ArrayList<Moto> getMotosFavoritas(@Valid @RequestBody List<Long> id_motos) {
			
		ArrayList<Moto> respuesta = new ArrayList();
			
			
		List<Moto> allMotos = getAllMotos();
		
		for (int x = 0; x < allMotos.size(); x ++) {
			long idMot = allMotos.get(x).getId_mot();
				
			
			for (int i = 0; i < id_motos.size(); i ++) {
				
				long idMotFav = id_motos.get(i);
				
				if (idMotFav == idMot) {
					respuesta.add(allMotos.get(x));
						
				}
				
			}
					
		}
		return respuesta;
			
	}
		
	
	
	//PARA OBTENER UNA MOTO POR ID
	@CrossOrigin
	@GetMapping("/motos/{id}")
	public ResponseEntity<Moto> getMotoById(@PathVariable(value="id") Long id_mot) {
		
		Moto mot=motoDAO.findOne(id_mot);
		
		if(mot==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(mot);
		
	}
	
	
	//PARA ACTUALIZAR UNA MOTO POR ID
	@CrossOrigin
	@PutMapping("/motos/{id}")
	public ResponseEntity<Moto> updateMoto(@PathVariable(value="id") Long id_mot,@Valid @RequestBody Moto motDetails) {
		
		Moto mot=motoDAO.findOne(id_mot);
		
		if(mot==null) {
			return ResponseEntity.notFound().build();
		}
		
		mot.setId_mar(motDetails.getId_mar());
		mot.setId_mod(motDetails.getId_mod());
		mot.setNom_mot(motDetails.getNom_mot());
		mot.setImg_mot(motDetails.getImg_mot());
		mot.setCil_mot(motDetails.getCil_mot());
		mot.setCic_mot(motDetails.getCic_mot());
		mot.setRef_mot(motDetails.getRef_mot());
		mot.setTrn_mot(motDetails.getTrn_mot());
		mot.setNmar_mot(motDetails.getNmar_mot());
		mot.setCha_mot(motDetails.getCha_mot());
		mot.setFrd_mot(motDetails.getFrd_mot());
		mot.setFrt_mot(motDetails.getFrt_mot());
		mot.setRud_mot(motDetails.getRud_mot());
		mot.setRut_mot(motDetails.getRut_mot());
		mot.setPes_mot(motDetails.getPes_mot());
		
		Moto updateMoto=motoDAO.save(mot);
		
		return ResponseEntity.ok().body(updateMoto);
		
	}
	
	
	//PARA ELIMINAR UNA MOTO POR ID
	@CrossOrigin
	@DeleteMapping("/motos/{id}")
	public ResponseEntity<Moto> deleteMoto(@PathVariable(value="id") Long id_mot) {
		
		Moto mot=motoDAO.findOne(id_mot);
		
		if(mot==null) {
			return ResponseEntity.notFound().build();
		}
		
		motoDAO.delete(mot);
		
		return ResponseEntity.ok().build();
		
	}
	
	

}
