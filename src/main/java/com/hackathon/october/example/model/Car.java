package com.hackathon.october.example.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder(toBuilder = true)
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id", updatable = false, unique = true, nullable = false)
    private Integer carId;

    @Column(name = "car_name", updatable = false, nullable = false)
    private String carName;

    @Column(name = "model", updatable = false, nullable = false)
    private Integer model;

    @Column(name = "person_id", insertable = false, updatable = false)
    private Integer personId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false, insertable = false, updatable = false)
//    private Person person;

}
