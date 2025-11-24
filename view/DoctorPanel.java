package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.HospitalManager;
import model.Doctor;
import controller.Validator;

public class DoctorPanel extends JPanel {

    private JTextField txtId, txtName, txtAge, txtSpec;
    private JButton btnAdd, btnRefresh, btnBack; // ADD btnBack
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
        btnBack = new JButton("Back to Dashboard"); // ADD THIS

        form.add(new JLabel("Doctor ID:")); form.add(txtId);
        form.add(new JLabel("Name:")); form.add(txtName);
        form.add(new JLabel("Age:")); form.add(txtAge);
        form.add(new JLabel("Specialization:")); form.add(txtSpec);
        form.add(btnAdd); form.add(btnBack); // ADD btnBack HERE

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

    // ADD THIS METHOD
    public void setBackToDashboardAction(ActionListener action) {
        btnBack.addActionListener(action);
    }

    private void addDoctor() {
        // ... existing addDoctor code ...
    }

    private void refreshList() {
        // ... existing refreshList code ...
    }
}