package com.MotorbikeHome.SpringBootAPI.repository;

import com.MotorbikeHome.SpringBootAPI.model.MotosFavoritas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MotosFavoritasRepository extends JpaRepository<MotosFavoritas, Long> {


}

