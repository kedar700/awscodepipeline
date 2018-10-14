package com.hackathon.october.example.repository;

import com.hackathon.october.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    //    @Query("select p,car from person p where car.model = :model and p.state = :state and p.person_id = car.person_id")
    List<Person> findByStateAndCarsModel(String State, Integer Model);

    Integer countByStateAndCarsModel(String State, Integer Model);


}
