package model;


public class Staff extends Person {
private String role;

public Staff(String id, String name, int age, String role) {
super(id, name, age);
this.role = role;
}

public String getRole() { return role; }
}