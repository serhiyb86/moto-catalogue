package org.acme.moto.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SpareType {
    @Id
    @GeneratedValue
    private int id;
    private String spareType;

    public SpareType(String spareType) {
        this.spareType = spareType;
    }

    public SpareType() {

    }
}
