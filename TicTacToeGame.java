import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGame extends JFrame implements ActionListener {

    JButton[][] buttons = new JButton[3][3];
    boolean xTurn = true;
    JLabel statusLabel;

    public TicTacToeGame() {
        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        Font font = new Font("Arial", Font.BOLD, 60);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(font);
                buttons[i][j].addActionListener(this);
                gridPanel.add(buttons[i][j]);
            }
        }

        statusLabel = new JLabel("Turn: Player X", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetGame());

        add(statusLabel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (!clicked.getText().equals("")) return;

        clicked.setText(xTurn ? "X" : "O");
        if (checkWin()) {
            statusLabel.setText("Player " + (xTurn ? "X" : "O") + " wins!");
            disableButtons();
        } else if (isBoardFull()) {
            statusLabel.setText("It's a draw!");
        } else {
            xTurn = !xTurn;
            statusLabel.setText("Turn: Player " + (xTurn ? "X" : "O"));
        }
    }

    boolean checkWin() {
        String symbol = xTurn ? "X" : "O";

        for (int i = 0; i < 3; i++) {
            if (symbol.equals(buttons[i][0].getText()) &&
                symbol.equals(buttons[i][1].getText()) &&
                symbol.equals(buttons[i][2].getText()))
                return true;
            if (symbol.equals(buttons[0][i].getText()) &&
                symbol.equals(buttons[1][i].getText()) &&
                symbol.equals(buttons[2][i].getText()))
                return true;
        }

        if (symbol.equals(buttons[0][0].getText()) &&
            symbol.equals(buttons[1][1].getText()) &&
            symbol.equals(buttons[2][2].getText()))
            return true;

        if (symbol.equals(buttons[0][2].getText()) &&
            symbol.equals(buttons[1][1].getText()) &&
            symbol.equals(buttons[2][0].getText()))
            return true;

        return false;
    }

    boolean isBoardFull() {
        for (JButton[] row : buttons)
            for (JButton b : row)
                if (b.getText().equals(""))
                    return false;
        return true;
    }

    void disableButtons() {
        for (JButton[] row : buttons)
            for (JButton b : row)
                b.setEnabled(false);
    }

    void resetGame() {
        xTurn = true;
        statusLabel.setText("Turn: Player X");
        for (JButton[] row : buttons)
            for (JButton b : row) {
                b.setText("");
                b.setEnabled(true);
            }
    }

    public static void main(String[] args) {
        new TicTacToeGame();
    }
}
