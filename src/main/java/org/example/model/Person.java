package org.example.model;

import javax.persistence.*;

@Entity //class, that is connected with DB.
// Class with this annotation must have empty constructor and at least one field with "id" annotation
@Table(name = "Person")
public class Person {

    @Id  //PRIMARY KEY column
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Hibernate doesn't care about this column. It is generated on DB side
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return this.name + ", " + this.age;
    }
}
