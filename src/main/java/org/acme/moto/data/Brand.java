package org.acme.moto.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Brand {
    @Id
    @GeneratedValue
    private int id;
    private String brand;
}
