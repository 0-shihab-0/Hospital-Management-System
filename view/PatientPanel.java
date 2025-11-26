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
        form.add(btnAdd);
        form.add(btnBack);

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

    public void setBackToDashboardAction(ActionListener action) {
        btnBack.addActionListener(action);
    }

    private void addPatient() {
        String id = txtId.getText();
        String name = txtName.getText();
        String ageStr = txtAge.getText();
        String disease = txtDisease.getText();

        if (Validator.isEmpty(id) || Validator.isEmpty(name) ||
                Validator.isEmpty(ageStr) || Validator.isEmpty(disease)) {
            JOptionPane.showMessageDialog(this, "All fields required!");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Age must be a number!");
            return;
        }

        Patient patient = new Patient(id, name, age, disease);
        manager.addPatient(patient);
        JOptionPane.showMessageDialog(this, "Patient Added!");

        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtDisease.setText("");
        refreshList();
        }

    private void refreshList() {
        listModel.clear();
        for (Patient p : manager.patients) {
            listModel.addElement(p.getId() + " — " + p.getName() + " (" + p.getAge() + ")"+ " (" + p.getDisease() + ")");
        }
    }
}