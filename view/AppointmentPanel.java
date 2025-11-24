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
    private JButton btnAdd, btnRefresh, btnBack; // ADD btnBack
    private JList<String> listAppointments;
    private DefaultListModel<String> listModel;
    private HospitalManager manager;

    public AppointmentPanel(HospitalManager manager) {
        this.manager = manager;
        setLayout(new BorderLayout(10,10));

        JPanel form = new JPanel(new GridLayout(5,2,6,6)); // Changed to 5 rows
        cbPatient = new JComboBox<>(); cbDoctor = new JComboBox<>();
        txtDate = new JTextField();
        btnAdd = new JButton("Add Appointment"); 
        btnRefresh = new JButton("Refresh List");
        btnBack = new JButton("Back to Dashboard"); // ADD THIS

        form.add(new JLabel("Select Patient:")); form.add(cbPatient);
        form.add(new JLabel("Select Doctor:")); form.add(cbDoctor);
        form.add(new JLabel("Date (YYYY-MM-DD):")); form.add(txtDate);
        form.add(btnAdd); form.add(btnBack); // ADD btnBack HERE

        listModel = new DefaultListModel<>();
        listAppointments = new JList<>(listModel);
        JScrollPane scroll = new JScrollPane(listAppointments);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(form, BorderLayout.WEST);
        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.add(btnRefresh, BorderLayout.SOUTH);

        add(mainPanel);

        btnAdd.addActionListener(e -> addAppointment());
        btnRefresh.addActionListener(e -> refreshAll());
        
        refreshAll();
    }

    // ADD THIS METHOD
    public void setBackToDashboardAction(ActionListener action) {
        btnBack.addActionListener(action);
    }

    private void addAppointment() {
        // ... existing addAppointment code ...
    }

    private void refreshAll() {
        // ... existing refreshAll code ...
    }
}