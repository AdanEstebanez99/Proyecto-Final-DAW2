package com.MotorbikeHome.SpringBootAPI.repository;

import com.MotorbikeHome.SpringBootAPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
