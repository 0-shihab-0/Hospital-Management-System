package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import model.HospitalManager;
import model.Room;
import controller.Validator;

public class RoomPanel extends JPanel {

    private JTextField txtId;
    private JComboBox<String> cbType;
    private JButton btnAdd, btnRefresh, btnBack;
    private JList<String> listRooms;
    private DefaultListModel<String> listModel;
    private HospitalManager manager;

    public RoomPanel(HospitalManager manager) {
        this.manager = manager;
        setLayout(new BorderLayout(10,10));

        JPanel form = new JPanel(new GridLayout(4,2,6,6)); 

        txtId = new JTextField();

        // Dropdown for room type
        cbType = new JComboBox<>(new String[] { "AC", "Non-AC", "Cabin", "General" });

        btnAdd = new JButton("Add Room"); 
        btnRefresh = new JButton("Refresh List");
        btnBack = new JButton("Back to Dashboard"); 

        form.add(new JLabel("Room ID:"));
        form.add(txtId);

        form.add(new JLabel("Type:"));
        form.add(cbType);

        form.add(btnAdd);
        form.add(btnBack);

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

    public void setBackToDashboardAction(ActionListener action) {
        btnBack.addActionListener(action);
    }

    private void addRoom() {
        String id = txtId.getText().trim();
        String type = (String) cbType.getSelectedItem();

        if (Validator.isEmpty(id)) {
            JOptionPane.showMessageDialog(this, "Room ID is required!");
            return;
        }

        // Duplicate check
        for (Room r : manager.rooms) {
            if (r.getRoomId().equals(id)) {
                JOptionPane.showMessageDialog(this,
                    "Room ID already exists! Choose another ID or delete the existing one.");
                return;
            }
        }

        Room room = new Room(id, type);
        manager.addRoom(room);

        JOptionPane.showMessageDialog(this, "Room Added!");

        txtId.setText("");
        refreshList();
    }

    private void refreshList() {
        listModel.clear();
        for (Room r : manager.rooms) {
            listModel.addElement(
                r.getRoomId() + " — " + r.getType() + " (occupied: " + r.isOccupied() + ")"
            );
        }
    }
}
