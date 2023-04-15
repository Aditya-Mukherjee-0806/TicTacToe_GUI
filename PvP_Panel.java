import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PvP_Panel extends JPanel implements ActionListener {
    JButton[] buttons = new JButton[9];
    boolean c = true;
    Result result = new Result();
    boolean check;

    PvP_Panel() {
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
        }
        buttons[0].setBounds(0, 0, 100, 100);
        buttons[1].setBounds(100, 0, 100, 100);
        buttons[2].setBounds(200, 0, 100, 100);
        buttons[3].setBounds(0, 100, 100, 100);
        buttons[4].setBounds(100, 100, 100, 100);
        buttons[5].setBounds(200, 100, 100, 100);
        buttons[6].setBounds(0, 200, 100, 100);
        buttons[7].setBounds(100, 200, 100, 100);
        buttons[8].setBounds(200, 200, 100, 100);

        this.setLayout(null);
        this.setBounds(100, 100, 500, 500);
        for (int i = 0; i < 9; i++) {
            this.add(buttons[i]);
        }
        this.add(result);
        this.setVisible(false);
    }

    public static boolean gameOver(JButton[] buttons) {
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals(""))
                return false;
        }
        return true;
    }

    public static boolean hasWinner(JButton[] buttons) {
        //checks rows
        if (buttons[0].getText().equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[2].getText())
                && !buttons[2].getText().equals(""))
            return true;
        else if (buttons[3].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[5].getText())
                && !buttons[5].getText().equals(""))
            return true;
        else if (buttons[6].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[8].getText())
                && !buttons[8].getText().equals(""))
            return true;
            //checks columns
        else if (buttons[0].getText().equals(buttons[3].getText()) && buttons[3].getText().equals(buttons[6].getText())
                && !buttons[6].getText().equals(""))
            return true;
        else if (buttons[1].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[7].getText())
                && !buttons[7].getText().equals(""))
            return true;
        else if (buttons[2].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[8].getText())
                && !buttons[8].getText().equals(""))
            return true;
            //checks diagonals
        else if (buttons[0].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText())
                && !buttons[8].getText().equals(""))
            return true;
        else return buttons[2].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[6].getText())
                    && !buttons[6].getText().equals("");
    }

    public static String getWinner(JButton[] buttons) {
        //checks rows
        if (buttons[0].getText().equals(buttons[1].getText()) && buttons[1].getText().equals(buttons[2].getText())
                && !buttons[2].getText().equals(""))
            return buttons[2].getText();
        else if (buttons[3].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[5].getText())
                && !buttons[5].getText().equals(""))
            return buttons[5].getText();
        else if (buttons[6].getText().equals(buttons[7].getText()) && buttons[7].getText().equals(buttons[8].getText())
                && !buttons[8].getText().equals(""))
            return buttons[8].getText();
            //checks columns
        else if (buttons[0].getText().equals(buttons[3].getText()) && buttons[3].getText().equals(buttons[6].getText())
                && !buttons[6].getText().equals(""))
            return buttons[6].getText();
        else if (buttons[1].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[7].getText())
                && !buttons[7].getText().equals(""))
            return buttons[7].getText();
        else if (buttons[2].getText().equals(buttons[5].getText()) && buttons[5].getText().equals(buttons[8].getText())
                && !buttons[8].getText().equals(""))
            return buttons[8].getText();
            //checks diagonals
        else if (buttons[0].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[8].getText())
                && !buttons[8].getText().equals(""))
            return buttons[8].getText();
        else if (buttons[2].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[6].getText())
                && !buttons[6].getText().equals(""))
            return buttons[6].getText();
        return "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        if (check) {
            for (int i = 0; i < 9; i++) buttons[i].setEnabled(false);
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                buttons[i].setEnabled(false);
                if (c) {
                    buttons[i].setText("X");
                    buttons[i].setVerticalAlignment(JLabel.CENTER);
                    buttons[i].setHorizontalAlignment(JLabel.CENTER);
                    buttons[i].setFont(new Font("ALGERIAN", Font.BOLD, 50));
                    c = false;
                    repaint();
                } else {
                    buttons[i].setText("O");
                    buttons[i].setHorizontalAlignment(JLabel.CENTER);
                    buttons[i].setFont(new Font("ALGERIAN", Font.BOLD, 50));
                    c = true;
                    repaint();
                }
                if (hasWinner(buttons)) {
                    result.setText(getWinner(buttons) + " Wins!");
                    result.setHorizontalAlignment(JLabel.CENTER);
                    result.setVisible(true);
                    check = true;
                } else if (gameOver(buttons)) {
                    result.setText("Game is a Draw");
                    result.setVisible(true);
                }
                break;
            }
        }
    }
}
