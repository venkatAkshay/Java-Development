import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    // Create buttons for the Tic-Tac-Toe grid
    private JButton[] buttons = new JButton[9];

    // Variable to track the player's turn (true for X, false for O)
    private boolean playerXTurn = true;

    public TicTacToe() {
        // Set up the frame
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        // Initialize the buttons and add them to the frame
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            buttons[i].setFocusPainted(false);
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();

        // Check if the button is already clicked
        if (!buttonClicked.getText().equals("")) {
            return;
        }

        // Set the text of the button to X or O depending on the turn
        if (playerXTurn) {
            buttonClicked.setText("X");
        } else {
            buttonClicked.setText("O");
        }

        // Check for a win or draw
        if (checkForWin()) {
            JOptionPane.showMessageDialog(this, "Player " + (playerXTurn ? "X" : "O") + " wins!");
            resetBoard();
        } else if (isBoardFull()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetBoard();
        }

        // Switch the turn
        playerXTurn = !playerXTurn;
    }

    private boolean checkForWin() {
        // Check all possible win combinations
        String[][] patterns = {
            {buttons[0].getText(), buttons[1].getText(), buttons[2].getText()},
            {buttons[3].getText(), buttons[4].getText(), buttons[5].getText()},
            {buttons[6].getText(), buttons[7].getText(), buttons[8].getText()},
            {buttons[0].getText(), buttons[3].getText(), buttons[6].getText()},
            {buttons[1].getText(), buttons[4].getText(), buttons[7].getText()},
            {buttons[2].getText(), buttons[5].getText(), buttons[8].getText()},
            {buttons[0].getText(), buttons[4].getText(), buttons[8].getText()},
            {buttons[2].getText(), buttons[4].getText(), buttons[6].getText()}
        };

        for (String[] pattern : patterns) {
            if (pattern[0].equals(pattern[1]) && pattern[1].equals(pattern[2]) && !pattern[0].equals("")) {
                return true;
            }
        }

        return false;
    }
// Checking for the outcome
    private boolean isBoardFull() {
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void resetBoard() {
        for (JButton button : buttons) {
            button.setText("");
        }
        playerXTurn = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
