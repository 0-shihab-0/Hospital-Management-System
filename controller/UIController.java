package controller;

import javax.swing.*;
import java.awt.*;
import view.DashboardPanel;
import view.PatientPanel;
import view.DoctorPanel;
import view.RoomPanel;
import view.AppointmentPanel;
import view.BillingPanel;

public class UIController {

    public UIController(DashboardPanel dashboardPanel, 
                       PatientPanel patientPanel,
                       DoctorPanel doctorPanel,
                       RoomPanel roomPanel,
                       AppointmentPanel appointmentPanel,
                       BillingPanel billingPanel,
                       JPanel cardPanel, 
                       CardLayout cardLayout) {

        // Dashboard to other panels
        dashboardPanel.btnPatient.addActionListener(e ->
                cardLayout.show(cardPanel, "patient"));

        dashboardPanel.btnDoctor.addActionListener(e ->
                cardLayout.show(cardPanel, "doctor"));

        dashboardPanel.btnRoom.addActionListener(e ->
                cardLayout.show(cardPanel, "room"));

        dashboardPanel.btnAppointment.addActionListener(e ->
                cardLayout.show(cardPanel, "appointment"));

        dashboardPanel.btnBilling.addActionListener(e ->
                cardLayout.show(cardPanel, "billing"));

        // Back to dashboard from all panels
        patientPanel.setBackToDashboardAction(e -> 
                cardLayout.show(cardPanel, "dashboard"));
        
        doctorPanel.setBackToDashboardAction(e -> 
                cardLayout.show(cardPanel, "dashboard"));
        
        roomPanel.setBackToDashboardAction(e -> 
                cardLayout.show(cardPanel, "dashboard"));
        
        appointmentPanel.setBackToDashboardAction(e -> 
                cardLayout.show(cardPanel, "dashboard"));
        
        billingPanel.setBackToDashboardAction(e -> 
                cardLayout.show(cardPanel, "dashboard"));
    }
}