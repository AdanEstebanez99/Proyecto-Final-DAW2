package com.MotorbikeHome.SpringBootAPI.repository;

import com.MotorbikeHome.SpringBootAPI.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
