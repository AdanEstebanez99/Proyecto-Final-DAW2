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

import com.MotorbikeHome.SpringBootAPI.dao.ComentarioDAO;
import com.MotorbikeHome.SpringBootAPI.model.Comentario;
import com.MotorbikeHome.SpringBootAPI.model.Moto;
import com.MotorbikeHome.SpringBootAPI.repository.ComentarioRepository;
import com.MotorbikeHome.SpringBootAPI.repository.MotoRepository;

@RestController
@RequestMapping("/api")
public class ComentarioController {
	
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
	ComentarioDAO comentarioDAO;
	
	//PARA GUARDAR UN COMENTARIO
	@CrossOrigin
	@PostMapping("/comentario")
	public Comentario createComentario(@Valid @RequestBody Comentario coment) {

		System.out.println("aaaa" + coment);
		return comentarioDAO.save(coment);
	}
	
	
	//PARA OBTENER TODOS LOS COMENTARIOS
	@GetMapping("/comentario")
	public List<Comentario> getAllComentario(){
		return comentarioDAO.findAll();
	}
	
	
	//PARA OBTENER LOS COMENTARIOS A PARTIR DE LOS ID'S
	@CrossOrigin
	@PostMapping("/comentario/all")
	public ArrayList<Comentario> getIdComentario(@Valid @RequestBody long id_mot) {

		ArrayList<Comentario> respuesta = new ArrayList();
		
		List<Comentario> comentarios = this.getAllComentario();
		
		for (int x = 0; x < comentarios.size(); x ++) {
			long idMoto = comentarios.get(x).getId_mot();
			
			if(idMoto == id_mot) {
				respuesta.add(comentarios.get(x));
			}
		}
			
		return respuesta;
	}
	
	
	//PARA ELIMINAR UN COMENTARIO POR ID
	@CrossOrigin
	@DeleteMapping("/comentario/delete/{id}")
	public ResponseEntity<Comentario> deleteComentario(@PathVariable(value="id") Long id_com) {
		
		Comentario coment=comentarioDAO.findOne(id_com);
		
		if(coment==null) {
			return ResponseEntity.notFound().build();
		}
		
		comentarioDAO.delete(coment);
		
		return ResponseEntity.ok().build();
		
	}
	
	

}
