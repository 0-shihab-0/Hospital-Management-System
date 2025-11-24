package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.HospitalManager;
import model.Appointment;
import model.Patient;
import model.Doctor;
import controller.Validator;
import java.util.UUID;

public class AppointmentPanel extends JPanel {

    private JComboBox<String> cbPatient, cbDoctor;
    private JTextField txtDate;
    private JButton btnAdd, btnRefresh, btnBack;
    private JList<String> listAppointments;
    private DefaultListModel<String> listModel;
    private HospitalManager manager;

    public AppointmentPanel(HospitalManager manager) {
        this.manager = manager;
        setLayout(new BorderLayout(10, 10));

        // Create components
        cbPatient = new JComboBox<>();
        cbDoctor = new JComboBox<>();
        txtDate = new JTextField();
        btnAdd = new JButton("Add Appointment");
        btnRefresh = new JButton("Refresh List");
        btnBack = new JButton("Back to Dashboard");

        // Form panel
        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));
        form.add(new JLabel("Select Patient:"));
        form.add(cbPatient);
        form.add(new JLabel("Select Doctor:"));
        form.add(cbDoctor);
        form.add(new JLabel("Date (YYYY-MM-DD):"));
        form.add(txtDate);
        form.add(btnAdd);
        form.add(btnBack);

        // List panel
        listModel = new DefaultListModel<>();
        listAppointments = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listAppointments);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        // Main layout
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(form, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(btnRefresh, BorderLayout.SOUTH);

        add(mainPanel);

        // Add event listeners
        btnAdd.addActionListener(e -> addAppointment());
        btnRefresh.addActionListener(e -> refreshAll());

        // Initial population
        refreshAll();
    }

    public void setBackToDashboardAction(ActionListener action) {
        btnBack.addActionListener(action);
    }

    private void addAppointment() {
        // Check if patient and doctor are selected
        if (cbPatient.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select a patient!");
            return;
        }
        if (cbDoctor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select a doctor!");
            return;
        }

        String date = txtDate.getText().trim();
        if (Validator.isEmpty(date)) {
            JOptionPane.showMessageDialog(this, "Please enter a date!");
            return;
        }
 
        try {
            // Extract IDs from dropdown selections
            String patientSelection = (String) cbPatient.getSelectedItem();
            String doctorSelection = (String) cbDoctor.getSelectedItem();

            String patientId = patientSelection.split(" — ")[0];
            String doctorId = doctorSelection.split(" — ")[0];

            // Find patient and doctor objects
            Patient patient = findPatientById(patientId);
            Doctor doctor = findDoctorById(doctorId);

            if (patient == null || doctor == null) {
                JOptionPane.showMessageDialog(this, "Invalid selection!");
                return;
            }

            // Create and add appointment
            String appointmentId = "A-" + UUID.randomUUID().toString().substring(0, 8);
            Appointment appointment = new Appointment(appointmentId, patient, doctor, date);
            manager.addAppointment(appointment);

            JOptionPane.showMessageDialog(this, 
                "Appointment created successfully!\nID: " + appointmentId + 
                "\nPatient: " + patient.getName() + 
                "\nDoctor: " + doctor.getName() + 
                "\nDate: " + date);

            // Clear and refresh
            txtDate.setText("");
            refreshAll();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error creating appointment: " + ex.getMessage());
        }
    }

    private Patient findPatientById(String id) {
        for (Patient patient : manager.patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }

    private Doctor findDoctorById(String id) {
        for (Doctor doctor : manager.doctors) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    public void refreshAll() {
        // Clear existing items
        cbPatient.removeAllItems();
        cbDoctor.removeAllItems();
        listModel.clear();

        // Add patients to dropdown
        for (Patient patient : manager.patients) {
            cbPatient.addItem(patient.getId() + " — " + patient.getName() + " (" + patient.getAge() + ")");
        }

        // Add doctors to dropdown
        for (Doctor doctor : manager.doctors) {
            cbDoctor.addItem(doctor.getId() + " — " + doctor.getName() + " (" + doctor.getSpecialization() + ")");
        }

        // Add appointments to list
        for (Appointment appointment : manager.appointments) {
            String appointmentText = String.format("%s — %s with Dr. %s on %s",
                appointment.getAppointmentId(),
                appointment.getPatient().getName(),
                appointment.getDoctor().getName(),
                appointment.getDate());
            listModel.addElement(appointmentText);
        }

        // If no appointments, show message
        if (manager.appointments.isEmpty()) {
            listModel.addElement("No appointments scheduled.");
        }

        // Debug information
        System.out.println("Appointment Panel Refresh:");
        System.out.println("  Patients: " + manager.patients.size());
        System.out.println("  Doctors: " + manager.doctors.size());
        System.out.println("  Appointments: " + manager.appointments.size());
        System.out.println("  Patient dropdown items: " + cbPatient.getItemCount());
        System.out.println("  Doctor dropdown items: " + cbDoctor.getItemCount());
    }
}