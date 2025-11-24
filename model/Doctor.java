package model;


public class Doctor extends Person {
private String specialization;


public Doctor(String id, String name, int age, String specialization) {
super(id, name, age);
this.specialization = specialization;
}

public String getSpecialization() { return specialization; }
}