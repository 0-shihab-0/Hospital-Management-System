package model;


// Inheritance: Doctor inherits Person
public class Doctor extends Person {
private String specialization;


public Doctor(String id, String name, int age, String specialization) {
super(id, name, age);
this.specialization = specialization;
}


// Encapsulation: Getter method
public String getSpecialization() { return specialization; }
}