package onlineexamsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherDashboard extends JFrame {
    private int teacherId;

    public TeacherDashboard(int teacherId) {
        this.teacherId = teacherId;

        setTitle("Teacher Dashboard");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton createExamButton = new JButton("Create Exam");
        createExamButton.setBounds(50, 50, 200, 25);
        panel.add(createExamButton);

        createExamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateExam(teacherId);
            }
        });
    }

    public static void main(String[] args) {
        new TeacherDashboard(1);
    }
}
