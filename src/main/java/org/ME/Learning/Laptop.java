package org.ME.Learning;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {
    @Id
    private int id;
    private String brand;
    @ManyToMany
    private List<Student> student =new ArrayList<Student>();

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

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Student> getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}
