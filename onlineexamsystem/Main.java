package onlineexamsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
         String url = "jdbc:mysql://localhost:3306/online_exam_system";
        String user = "root"; // Replace with your MySQL username
        String password = "root"; // Replace with your MySQL password

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Initialize the application
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showMainMenu();
            }
        });
    }

    private static void showMainMenu() {
        // Create a frame for the main menu
        JFrame frame = new JFrame("Online Examination System");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create a panel to hold the buttons
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Display the frame
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create a register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 50, 200, 25);
        panel.add(registerButton);

        // Create a login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 90, 200, 25);
        panel.add(loginButton);

        // Action listener for Register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the registration window
                new UserRegistration();
            }
        });

        // Action listener for Login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the login window
                new Login();
            }
        });
    }
}
