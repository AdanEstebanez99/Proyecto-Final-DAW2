package com.MotorbikeHome.SpringBootAPI.repository;

import com.MotorbikeHome.SpringBootAPI.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ComentarioRepository extends JpaRepository<Comentario, Long> {


}