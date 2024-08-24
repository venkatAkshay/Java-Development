package onlineexamsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateExam extends JFrame{
    private JTextField examNameField;
    private int teacherId;

    public CreateExam(int teacherId) {
        this.teacherId = teacherId;

        setTitle("Create Exam");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel examLabel = new JLabel("Exam Name:");
        examLabel.setBounds(10, 20, 80, 25);
        panel.add(examLabel);

        examNameField = new JTextField(20);
        examNameField.setBounds(100, 20, 165, 25);
        panel.add(examNameField);

        JButton createButton = new JButton("Create");
        createButton.setBounds(10, 50, 255, 25);
        panel.add(createButton);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createExam();
            }
        });
    }

    private void createExam() {
        String examName = examNameField.getText();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO exams (exam_name, teacher_id) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, examName);
            statement.setInt(2, teacherId);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Exam created successfully!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
