package onlineexamsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDashboard extends JFrame {
    private int studentId;

    public StudentDashboard(int studentId) {
        this.studentId = studentId;

        setTitle("Student Dashboard");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton takeExamButton = new JButton("Take Exam");
        takeExamButton.setBounds(50, 50, 200, 25);
        panel.add(takeExamButton);

        takeExamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TakeExam(studentId);
            }
        });
    }

    public static void main(String[] args) {
        new StudentDashboard(1);
    }
}
