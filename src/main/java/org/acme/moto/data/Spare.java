package org.acme.moto.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Spare {
    @Id
    @GeneratedValue
    private long id;
    private SpareType spareType;
    private String spareName;
    private String description;
    private String techDescription;
    private double price;
    private Availability availability;
}
