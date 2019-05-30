package com.MotorbikeHome.SpringBootAPI.repository;

import com.MotorbikeHome.SpringBootAPI.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MotoRepository extends JpaRepository<Moto, Long> {

}
