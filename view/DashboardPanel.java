package view;


import javax.swing.*;
import java.awt.*;


public class DashboardPanel extends JPanel {


public JButton btnPatient, btnDoctor, btnRoom, btnAppointment, btnBilling;


public DashboardPanel() {
setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.insets = new Insets(10, 10, 10, 10);
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.gridx = 0;
gbc.gridy = 0;


btnPatient = new JButton("Manage Patients");
btnDoctor = new JButton("Manage Doctors");
btnRoom = new JButton("Manage Rooms");
btnAppointment = new JButton("Manage Appointments");
btnBilling = new JButton("Manage Billing");


add(btnPatient, gbc);
gbc.gridy++;
add(btnDoctor, gbc);
gbc.gridy++;
add(btnRoom, gbc);
gbc.gridy++;
add(btnAppointment, gbc);
gbc.gridy++;
add(btnBilling, gbc);
}
}