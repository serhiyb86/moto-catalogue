package org.acme.moto.data;

import jakarta.persistence.*;

@Entity
public class Spare {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private SpareType spareType;
    private String spareName;
    private String description;
    private String techDescription;
    private double price;
    private Availability availability;
}
