package model;


// Inheritance: Patient inherits Person
public class Patient extends Person {
private String disease;


public Patient(String id, String name, int age, String disease) {
super(id, name, age);
this.disease = disease;
}


// Encapsulation: Getter method
public String getDisease() { return disease; }
public void setDisease(String disease) { this.disease = disease; }
}