package com.hackathon.october.example.controller;

import com.hackathon.october.example.model.Person;
import com.hackathon.october.example.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class SpringController {

    @Autowired
    private final PersonService personService;


    @GetMapping("/hack")
    public List<String> findModls() {
        log.info("Fetching All Models");
        List<String> sample = new ArrayList<>();
        sample.add("AwsRebels");
        sample.add("Hackathon");
        return sample;
    }

    @GetMapping("/getperson")
    public List<Person> findPersonRecordByParams(@RequestParam(value = "state") String state, @RequestParam(value = "model", required = false) Integer model) {
        log.info("Fetching All Person Records");
        return personService.getRecords(state, model);
    }

    @GetMapping("/getpeoplecount")
    public Integer countPersonRecordByParams(@RequestParam(value = "state") String state, @RequestParam(value = "model", required = false) Integer model) {
        log.info("Count Person Records by criteria");
        return personService.countRecords(state, model);
    }

    @GetMapping("/execute")
    public Page<Person> findAllPeople(Pageable pageable) {
        log.info("Fetching All Person Records");
        return personService.getPaddRecords(pageable);
    }

}
