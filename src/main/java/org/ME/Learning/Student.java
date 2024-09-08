package org.ME.Learning;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Student {
    @Id
    private int id;
    private StudentName name;
    private int age;

    public void setId(int id) {
        this.id = id;
    }
    public void setName(StudentName name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public StudentName getName() {
        return name;
    }
     public int getAge() {
        return age;
     }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                '}';
    }
}
