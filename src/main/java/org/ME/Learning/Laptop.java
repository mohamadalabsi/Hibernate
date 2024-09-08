package org.ME.Learning;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Laptop {
    @Id
    private int id;
    private String brand;

    public void setId(int id) {
        this.id = id;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}
