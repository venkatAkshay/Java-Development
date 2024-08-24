package onlineexamsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TakeExam extends JFrame {
    private int studentId;
    private JComboBox<String> examList;
    private int selectedExamId;

    public TakeExam(int studentId) {
        this.studentId = studentId;

        setTitle("Take Exam");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        loadExams();

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel examLabel = new JLabel("Select Exam:");
        examLabel.setBounds(10, 20, 80, 25);
        panel.add(examLabel);

        examList = new JComboBox<>();
        examList.setBounds(100, 20, 165, 25);
        panel.add(examList);

        JButton startExamButton = new JButton("Start Exam");
        startExamButton.setBounds(10, 50, 255, 25);
        panel.add(startExamButton);

        startExamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedExamId = examList.getSelectedIndex() + 1; // Assuming the index matches the exam_id
                // Implement the logic to start the exam
            }
        });
    }

    private void loadExams() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM exams";
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String examName = resultSet.getString("exam_name");
                examList.addItem(examName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
