package com.MotorbikeHome.SpringBootAPI.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.MotorbikeHome.SpringBootAPI.dao.UsuarioDAO;
import com.MotorbikeHome.SpringBootAPI.model.Usuario;

@RestController
@RequestMapping("/api")

public class UsuarioController {
	
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
	UsuarioDAO usuarioDAO;
	
	//PARA GUARDAR UN USUARIO
	@PostMapping("/usuarios")
	public Usuario createUsuario(@Valid @RequestBody Usuario usu) {
		
		String respuesta = "";
		
		String nickUsu = usu.getNick_usu();
		
		List<Usuario> usuario = getAllUsuarios();
			
		for (int x = 0; x < usuario.size(); x ++) {
			String nick = usuario.get(x).getNick_usu();
			
			System.out.println(nick);
				
			if (nick.equals(nickUsu)) {
				
				System.out.println("Usuario Registrado");
				respuesta = "usuReg";
				return null;
				
			} else {
				System.out.println("Usuario no registrado");
				respuesta = "usuNoReg";
				return usuarioDAO.save(usu);
				
			}
				
		}
		return null;
		
	}
	
	
	//PARA OBTENER TODAS LOS USUARIOS
	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios(){
		return usuarioDAO.findAll();
	}
	
	
	//PARA OBTENER UN USUARIO POR NICK Y CONTRASEÑA
	@CrossOrigin
	@PostMapping("/usuarios/login")
	public Usuario loginUsuario(@Valid @RequestBody Map<String, Object> datos) {
			
		String nick_usu = datos.get("nick_usu").toString();
		String con_usu = datos.get("con_usu").toString();
			
		List<Usuario> usuario = getAllUsuarios();
		
		Usuario respuesta = null;
		
		
		for (int x = 0; x < usuario.size(); x ++) {
			String nick = usuario.get(x).getNick_usu();
			String pass = usuario.get(x).getCon_usu();
			
			if ((nick.equals(nick_usu)) && (pass.equals(con_usu))) {
				
				respuesta = usuario.get(x);				
				
			}
			
		}
			
		return respuesta;
		
	}
	
	
	//PARA OBTENER UN USUARIO POR ID
	@CrossOrigin
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value="id") Long id_usu) {
			
		Usuario usu=usuarioDAO.findOne(id_usu);
			
		if(usu==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(usu);
			
	}
	
	
	//PARA ACTUALIZAR UN USUARIO POR ID
	@CrossOrigin
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value="id") Long id_usu,@Valid @RequestBody Usuario usuDetails) {
		
		Usuario usu=usuarioDAO.findOne(id_usu);
		
		if(usu==null) {
			return ResponseEntity.notFound().build();
		}
		
		usu.setNick_usu(usuDetails.getNick_usu());
		usu.setNom_usu(usuDetails.getNom_usu());
		usu.setApe_usu(usuDetails.getApe_usu());
		usu.setCon_usu(usuDetails.getCon_usu());
		usu.setCor_usu(usuDetails.getCor_usu());
		usu.setCol_usu(usuDetails.getCol_usu());
		usu.setRol_usu(usuDetails.getRol_usu());
		
		Usuario updateUsuario=usuarioDAO.save(usu);
		
		return ResponseEntity.ok().body(updateUsuario);
		
	}
	
	
	//PARA ELIMINAR UN USUARIO POR ID
	@CrossOrigin
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable(value="id") Long id_usu) {
		
		Usuario usu=usuarioDAO.findOne(id_usu);
		
		if(usu==null) {
			return ResponseEntity.notFound().build();
		}
		
		usuarioDAO.delete(usu);
		
		return ResponseEntity.ok().build();
		
	}
	
}

