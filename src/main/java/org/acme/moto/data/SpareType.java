package org.acme.moto.data;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class SpareType {
    @Id
    @GeneratedValue
    private int id;
    private String spareType;
}
