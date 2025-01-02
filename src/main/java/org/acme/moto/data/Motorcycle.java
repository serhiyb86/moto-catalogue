package org.acme.moto.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Motorcycle {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Brand brand;
    private String model;
    private double engineVolume;
    private int year;
    @OneToMany
    private List<Spare> spareList;

}
