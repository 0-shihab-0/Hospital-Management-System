package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.HospitalManager;
import model.Patient;
import controller.Validator;

public class PatientPanel extends JPanel {

    private JTextField txtId, txtName, txtAge, txtDisease;
    private JButton btnAdd, btnBack, btnRefresh;
    private JList<String> listPatients;
    private DefaultListModel<String> listModel;
    private HospitalManager manager;

    public PatientPanel(HospitalManager manager) {
        this.manager = manager;
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(5, 2, 6, 6));
        txtId = new JTextField();
        txtName = new JTextField();
        txtAge = new JTextField();
        txtDisease = new JTextField();
        btnAdd = new JButton("Add Patient");
        btnBack = new JButton("Back to Dashboard");
        btnRefresh = new JButton("Refresh List");

        form.add(new JLabel("Patient ID:")); form.add(txtId);
        form.add(new JLabel("Name:")); form.add(txtName);
        form.add(new JLabel("Age:")); form.add(txtAge);
        form.add(new JLabel("Disease:")); form.add(txtDisease);
        form.add(btnAdd); form.add(btnBack);

        listModel = new DefaultListModel<>();
        listPatients = new JList<>(listModel);
        JScrollPane scroll = new JScrollPane(listPatients);

        JPanel right = new JPanel(new BorderLayout());
        right.add(scroll, BorderLayout.CENTER);
        right.add(btnRefresh, BorderLayout.SOUTH);

        add(form, BorderLayout.WEST);
        add(right, BorderLayout.CENTER);

        btnAdd.addActionListener(e -> addPatient());
        btnRefresh.addActionListener(e -> refreshList());

        refreshList();
    }

    // Add this method to set the back action
    public void setBackToDashboardAction(ActionListener action) {
        btnBack.addActionListener(action);
    }

    private void addPatient() {
        // ... existing addPatient code ...
    }

    private void refreshList() {
        // ... existing refreshList code ...
    }
}