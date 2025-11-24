package view;

import javax.swing.*;
import java.awt.*;
import controller.UIController;
import model.HospitalManager;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainFrame() {
        setTitle("Hospital Management System");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        HospitalManager manager = new HospitalManager();

        // Create panels
        DashboardPanel dashboardPanel = new DashboardPanel();
        PatientPanel patientPanel = new PatientPanel(manager);
        DoctorPanel doctorPanel = new DoctorPanel(manager);
        RoomPanel roomPanel = new RoomPanel(manager);
        AppointmentPanel appointmentPanel = new AppointmentPanel(manager);
        BillingPanel billingPanel = new BillingPanel(manager);

        // Card system
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(dashboardPanel, "dashboard");
        cardPanel.add(patientPanel, "patient");
        cardPanel.add(doctorPanel, "doctor");
        cardPanel.add(roomPanel, "room");
        cardPanel.add(appointmentPanel, "appointment");
        cardPanel.add(billingPanel, "billing");

        add(cardPanel);

        // FIXED: Use the updated UIController that takes all panels
        new UIController(dashboardPanel, patientPanel, doctorPanel, roomPanel, 
                        appointmentPanel, billingPanel, cardPanel, cardLayout);

        setVisible(true);
    }
}