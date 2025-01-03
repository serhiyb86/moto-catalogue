package org.acme.moto.data;

import jakarta.persistence.*;

@Entity
public class Spare {
    @Id
    @SequenceGenerator(
            name = "SPARE_SEQ",
            sequenceName = "SPARE_SEQ",
            initialValue = 1,
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SPARE_SEQ")
    private long id;
    @ManyToOne
    private SpareType spareType;
    private String spareName;
    private String description;
    private String techDescription;
    private double price;
    private Availability availability;

    public Spare() {
    }

    public Spare(SpareType spareType, String spareName, String description, String techDescription, double price, Availability availability) {
        this.spareType = spareType;
        this.spareName = spareName;
        this.description = description;
        this.techDescription = techDescription;
        this.price = price;
        this.availability = availability;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SpareType getSpareType() {
        return spareType;
    }

    public void setSpareType(SpareType spareType) {
        this.spareType = spareType;
    }

    public String getSpareName() {
        return spareName;
    }

    public void setSpareName(String spareName) {
        this.spareName = spareName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechDescription() {
        return techDescription;
    }

    public void setTechDescription(String techDescription) {
        this.techDescription = techDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}
