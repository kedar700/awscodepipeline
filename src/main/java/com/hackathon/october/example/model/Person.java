package com.hackathon.october.example.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder(toBuilder = true)
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id", updatable = false, unique = true, nullable = false)
    private Integer personId;

    @Column(name = "first_name", updatable = false, nullable = false)
    private String firstName;

    @Column(name = "last_name", updatable = false, nullable = false)
    private String lastName;

    @Column(name = "email", updatable = false, nullable = false)
    private String email;

    @Column(name = "gender", updatable = false, nullable = false)
    private String gender;

    @Column(name = "state", updatable = false, nullable = false)
    private String state;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "person_id")
    private List<Car> cars = new ArrayList<>();


}
