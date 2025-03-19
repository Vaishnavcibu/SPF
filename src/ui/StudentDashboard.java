package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboard extends JFrame {
    private JButton findStudyPartnerButton;
    private JButton viewRequestsButton;
    private JButton logoutButton;

    public StudentDashboard() {
        setTitle("Student Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        findStudyPartnerButton = new JButton("Find Study Partner");
        viewRequestsButton = new JButton("View Requests");
        logoutButton = new JButton("Logout");

        add(findStudyPartnerButton);
        add(viewRequestsButton);
        add(logoutButton);

        findStudyPartnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Finding a study partner...");
            }
        });

        viewRequestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Viewing study requests...");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "Logged out successfully.");
            }
        });
    }
}