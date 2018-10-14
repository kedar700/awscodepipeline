package com.hackathon.october.example.repository;

import com.hackathon.october.example.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {


    List<Car> findByModelAndPersonId(Integer Model, Integer personId);
}
