package org.ME.Learning;


import java.math.BigDecimal;

public class Car {
    private  int id ;
    private String make;
    private String model;
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
}
