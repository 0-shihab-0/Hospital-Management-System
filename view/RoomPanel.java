package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.HospitalManager;
import model.Room;
import controller.Validator;

public class RoomPanel extends JPanel {

    private JTextField txtId, txtType;
    private JButton btnAdd, btnRefresh, btnBack; // ADD btnBack
    private JList<String> listRooms;
    private DefaultListModel<String> listModel;
    private HospitalManager manager;

    public RoomPanel(HospitalManager manager) {
        this.manager = manager;
        setLayout(new BorderLayout(10,10));

        JPanel form = new JPanel(new GridLayout(4,2,6,6)); // Changed to 4 rows
        txtId = new JTextField(); txtType = new JTextField();
        btnAdd = new JButton("Add Room"); 
        btnRefresh = new JButton("Refresh List");
        btnBack = new JButton("Back to Dashboard"); // ADD THIS

        form.add(new JLabel("Room ID:")); form.add(txtId);
        form.add(new JLabel("Type:")); form.add(txtType);
        form.add(btnAdd); form.add(btnBack); // ADD btnBack HERE

        listModel = new DefaultListModel<>();
        listRooms = new JList<>(listModel);
        JScrollPane scroll = new JScrollPane(listRooms);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(form, BorderLayout.WEST);
        mainPanel.add(scroll, BorderLayout.CENTER);
        mainPanel.add(btnRefresh, BorderLayout.SOUTH);

        add(mainPanel);

        btnAdd.addActionListener(e -> addRoom());
        btnRefresh.addActionListener(e -> refreshList());
        
        refreshList();
    }

    // ADD THIS METHOD
    public void setBackToDashboardAction(ActionListener action) {
        btnBack.addActionListener(action);
    }

    private void addRoom() {
        // ... existing addRoom code ...
    }

    private void refreshList() {
        // ... existing refreshList code ...
    }
}