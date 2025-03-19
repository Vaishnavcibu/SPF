package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {
    private JButton viewAllUsersButton;
    private JButton monitorStudyGroupsButton;
    private JButton removeInactiveUsersButton;
    private JButton logoutButton;

    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        viewAllUsersButton = new JButton("View All Users");
        monitorStudyGroupsButton = new JButton("Monitor Study Groups");
        removeInactiveUsersButton = new JButton("Remove Inactive Users");
        logoutButton = new JButton("Logout");

        add(viewAllUsersButton);
        add(monitorStudyGroupsButton);
        add(removeInactiveUsersButton);
        add(logoutButton);

        viewAllUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Displaying all users...");
            }
        });

        monitorStudyGroupsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Monitoring study groups...");
            }
        });

        removeInactiveUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Removing inactive users...");
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