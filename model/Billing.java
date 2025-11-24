package model;


public class Billing {
private String billId;
private Patient patient;
private double amount;


public Billing(String billId, Patient patient, double amount) {
this.billId = billId;
this.patient = patient;
this.amount = amount;
}


public String getBillId() { return billId; }
public Patient getPatient() { return patient; }
public double getAmount() { return amount; }
}