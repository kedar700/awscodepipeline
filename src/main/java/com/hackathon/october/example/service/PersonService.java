package com.hackathon.october.example.service;

import com.hackathon.october.example.model.Person;
import com.hackathon.october.example.repository.CarRepository;
import com.hackathon.october.example.repository.PersonRepository;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Data
@Service
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final CarRepository carRepository;

    public Page<Person> getPaddRecords(Pageable pageable) {

        return personRepository.findAll(pageable);
    }

    public List<Person> getRecords(String state, Integer model) {
        return personRepository.findByStateAndCarsModel(state, model);
    }

    public Integer countRecords(String state, Integer model) {
        return personRepository.countByStateAndCarsModel(state, model);
    }
}
