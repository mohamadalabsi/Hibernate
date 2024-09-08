package org.ME.Learning;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
    @Id
    private int rollNumber;
    private String name;
    private int marks;
    @OneToOne
    private Laptop laptop;

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
    public int getId() {
        return rollNumber;
    }
    public String getName() {
        return name;
    }
     public int getAge() {
        return marks;
     }
     public Laptop getLaptop() {
        return laptop;
     }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", laptop=" + laptop +
                '}';
    }
}
