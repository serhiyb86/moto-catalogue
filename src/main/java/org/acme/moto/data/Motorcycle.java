package org.acme.moto.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Motorcycle {
    @Id
    @GeneratedValue
    private int id;
    private Brand brand;
    private String model;
    private double engineVolume;
    private int year;
    @OneToMany
    private List<Spare> spareList;

}
