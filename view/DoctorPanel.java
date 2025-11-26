package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.HospitalManager;
import model.Doctor;
import controller.Validator;

public class DoctorPanel extends JPanel {

    private JTextField txtId, txtName, txtAge, txtSpec;
    private JButton btnAdd, btnRefresh, btnBack;
    private JList<String> listDoctors;
    private DefaultListModel<String> listModel;
    private HospitalManager manager;

    public DoctorPanel(HospitalManager manager) {
        this.manager = manager;
        setLayout(new BorderLayout(10,10));

        JPanel form = new JPanel(new GridLayout(5,2,6,6));
        txtId = new JTextField(); txtName = new JTextField(); txtAge = new JTextField(); txtSpec = new JTextField();
        btnAdd = new JButton("Add Doctor"); 
        btnRefresh = new JButton("Refresh List");
        btnBack = new JButton("Back to Dashboard");

        form.add(new JLabel("Doctor ID:")); form.add(txtId);
        form.add(new JLabel("Name:"));
        form.add(txtName);
        form.add(new JLabel("Age:"));
        form.add(txtAge);
        form.add(new JLabel("Specialization:"));
        form.add(txtSpec);
        form.add(btnAdd); form.add(btnBack);

        listModel = new DefaultListModel<>();
        listDoctors = new JList<>(listModel);
        JScrollPane scroll = new JScrollPane(listDoctors);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(form, BorderLayout.WEST);
        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.add(btnRefresh, BorderLayout.SOUTH);

        add(mainPanel);

        btnAdd.addActionListener(e -> addDoctor());
        btnRefresh.addActionListener(e -> refreshList());
        
        refreshList();
    }

    public void setBackToDashboardAction(ActionListener action) {
        btnBack.addActionListener(action);
    }

    private void addDoctor() {
        String id = txtId.getText();
        String name = txtName.getText();
        String ageStr = txtAge.getText();
        String spec = txtSpec.getText();

        if (Validator.isEmpty(id) || Validator.isEmpty(name) || 
            Validator.isEmpty(ageStr) || Validator.isEmpty(spec)) {
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

        Doctor doctor = new Doctor(id, name, age, spec);
        manager.addDoctor(doctor);
        JOptionPane.showMessageDialog(this, "Doctor Added!");

        txtId.setText(""); txtName.setText(""); txtAge.setText(""); txtSpec.setText("");
        refreshList();
        }

    private void refreshList() {
listModel.clear();
        for (Doctor d : manager.doctors) {
            listModel.addElement(d.getId() + " — " + d.getName() + " (" + d.getSpecialization() + ")");
        }
        }
}