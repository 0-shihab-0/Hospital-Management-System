package model;

import java.util.ArrayList;

public class HospitalManager {
    public ArrayList<Patient> patients = new ArrayList<>();
    public ArrayList<Doctor> doctors = new ArrayList<>();
    public ArrayList<Appointment> appointments = new ArrayList<>();
    public ArrayList<Room> rooms = new ArrayList<>();
    public ArrayList<Billing> billings = new ArrayList<>();

    public void addPatient(Patient p) { patients.add(p); }
    public void addDoctor(Doctor d) { doctors.add(d); }
    public void addAppointment(Appointment a) { appointments.add(a); }
    public void addRoom(Room r) { rooms.add(r); }
    public void addBilling(Billing b) { billings.add(b); }
}