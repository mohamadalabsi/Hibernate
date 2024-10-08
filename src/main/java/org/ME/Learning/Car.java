package org.ME.Learning;


import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.hibernate.annotations.Cache;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity // name("car_table") if you want to creat a new table but with a different name
//@Table(name="car_table") the same thing
@Cacheable
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
public class Car {
    @Id
    private  int id ;
//    @Column (name="make_column")
    private String make;
    private String model;
//    @Transient this one if you do  not want store this (price) as a column into the table
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
