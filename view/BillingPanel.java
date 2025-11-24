package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.HospitalManager;
import model.Patient;
import model.Billing;
import controller.Validator;
import java.util.UUID;

public class BillingPanel extends JPanel {

    private JComboBox<String> cbPatient;
    private JTextField txtAmount;
    private JButton btnAdd, btnRefresh, btnBack; // ADD btnBack
    private JList<String> listBills;
    private DefaultListModel<String> listModel;
    private HospitalManager manager;

    public BillingPanel(HospitalManager manager) {
        this.manager = manager;
        setLayout(new BorderLayout(10,10));

        JPanel form = new JPanel(new GridLayout(4,2,6,6)); // Changed to 4 rows
        cbPatient = new JComboBox<>(); txtAmount = new JTextField();
        btnAdd = new JButton("Create Bill"); 
        btnRefresh = new JButton("Refresh List");
        btnBack = new JButton("Back to Dashboard"); // ADD THIS

        form.add(new JLabel("Select Patient:")); form.add(cbPatient);
        form.add(new JLabel("Amount:")); form.add(txtAmount);
        form.add(btnAdd); form.add(btnBack); // ADD btnBack HERE

        listModel = new DefaultListModel<>();
        listBills = new JList<>(listModel);
        JScrollPane scroll = new JScrollPane(listBills);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(form, BorderLayout.WEST);
        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.add(btnRefresh, BorderLayout.SOUTH);

        add(mainPanel);

        btnAdd.addActionListener(e -> addBill());
        btnRefresh.addActionListener(e -> refreshAll());
        
        refreshAll();
    }

    // ADD THIS METHOD
    public void setBackToDashboardAction(ActionListener action) {
        btnBack.addActionListener(action);
    }

    private void addBill() {
        // ... existing addBill code ...
    }

    private void refreshAll() {
        cbPatient.removeAllItems(); 
        listModel.clear();
        
        for (Patient p : manager.patients) 
            cbPatient.addItem(p.getId() + " — " + p.getName());
        
        for (Billing b : manager.billings) 
            listModel.addElement(b.getBillId() + " — " + b.getPatient().getName() + " : $" + b.getAmount());
        
        if (manager.billings.isEmpty()) {
            listModel.addElement("No bills created yet.");
        }
    }
}