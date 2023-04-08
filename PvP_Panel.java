import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PvP_Panel extends JPanel implements ActionListener {
    JLabel[] labels = new JLabel[9];
    JButton[] buttons = new JButton[9];
    boolean c = true;
    Result result = new Result();
    boolean check;

    PvP_Panel() {
        for (int i = 0; i < 9; i++) {
            labels[i] = new JLabel();
            buttons[i] = new JButton();
        }

        labels[0].setBounds(0, 0, 100, 100);
        labels[1].setBounds(100, 0, 100, 100);
        labels[2].setBounds(200, 0, 100, 100);
        labels[3].setBounds(0, 100, 100, 100);
        labels[4].setBounds(100, 100, 100, 100);
        labels[5].setBounds(200, 100, 100, 100);
        labels[6].setBounds(0, 200, 100, 100);
        labels[7].setBounds(100, 200, 100, 100);
        labels[8].setBounds(200, 200, 100, 100);

        buttons[0].setBounds(0, 0, 100, 100);
        buttons[1].setBounds(100, 0, 100, 100);
        buttons[2].setBounds(200, 0, 100, 100);
        buttons[3].setBounds(0, 100, 100, 100);
        buttons[4].setBounds(100, 100, 100, 100);
        buttons[5].setBounds(200, 100, 100, 100);
        buttons[6].setBounds(0, 200, 100, 100);
        buttons[7].setBounds(100, 200, 100, 100);
        buttons[8].setBounds(200, 200, 100, 100);

        for (int i = 0; i < 9; i++) buttons[i].addActionListener(this);

        this.setLayout(null);
        this.setBounds(100, 100, 500, 500);
        for (int i = 0; i < 9; i++) {
            this.add(labels[i]);
            this.add(buttons[i]);
        }
        this.add(result);
        this.setVisible(false);
    }

    public static boolean gameOver(JLabel[] labels) {
        for (int i = 0; i < 9; i++) {
            if (labels[i].getText().equals(""))
                return false;
        }
        return true;
    }

    public static boolean hasWinner(JLabel[] labels) {
        //checks rows
        if (labels[0].getText().equals(labels[1].getText()) && labels[1].getText().equals(labels[2].getText())
                && !labels[2].getText().equals(""))
            return true;
        else if (labels[3].getText().equals(labels[4].getText()) && labels[4].getText().equals(labels[5].getText())
                && !labels[5].getText().equals(""))
            return true;
        else if (labels[6].getText().equals(labels[7].getText()) && labels[7].getText().equals(labels[8].getText())
                && !labels[8].getText().equals(""))
            return true;
            //checks columns
        else if (labels[0].getText().equals(labels[3].getText()) && labels[3].getText().equals(labels[6].getText())
                && !labels[6].getText().equals(""))
            return true;
        else if (labels[1].getText().equals(labels[4].getText()) && labels[4].getText().equals(labels[7].getText())
                && !labels[7].getText().equals(""))
            return true;
        else if (labels[2].getText().equals(labels[5].getText()) && labels[5].getText().equals(labels[8].getText())
                && !labels[8].getText().equals(""))
            return true;
            //checks diagonals
        else if (labels[0].getText().equals(labels[4].getText()) && labels[4].getText().equals(labels[8].getText())
                && !labels[8].getText().equals(""))
            return true;
        else return labels[2].getText().equals(labels[4].getText()) && labels[4].getText().equals(labels[6].getText())
                    && !labels[6].getText().equals("");
    }

    public static String getWinner(JLabel[] labels) {
        //checks rows
        if (labels[0].getText().equals(labels[1].getText()) && labels[1].getText().equals(labels[2].getText())
                && !labels[2].getText().equals(""))
            return labels[2].getText();
        else if (labels[3].getText().equals(labels[4].getText()) && labels[4].getText().equals(labels[5].getText())
                && !labels[5].getText().equals(""))
            return labels[5].getText();
        else if (labels[6].getText().equals(labels[7].getText()) && labels[7].getText().equals(labels[8].getText())
                && !labels[8].getText().equals(""))
            return labels[8].getText();
            //checks columns
        else if (labels[0].getText().equals(labels[3].getText()) && labels[3].getText().equals(labels[6].getText())
                && !labels[6].getText().equals(""))
            return labels[6].getText();
        else if (labels[1].getText().equals(labels[4].getText()) && labels[4].getText().equals(labels[7].getText())
                && !labels[7].getText().equals(""))
            return labels[7].getText();
        else if (labels[2].getText().equals(labels[5].getText()) && labels[5].getText().equals(labels[8].getText())
                && !labels[8].getText().equals(""))
            return labels[8].getText();
            //checks diagonals
        else if (labels[0].getText().equals(labels[4].getText()) && labels[4].getText().equals(labels[8].getText())
                && !labels[8].getText().equals(""))
            return labels[8].getText();
        else if (labels[2].getText().equals(labels[4].getText()) && labels[4].getText().equals(labels[6].getText())
                && !labels[6].getText().equals(""))
            return labels[6].getText();
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
                    labels[i].setText("X");
                    labels[i].setVerticalAlignment(JLabel.CENTER);
                    labels[i].setHorizontalAlignment(JLabel.CENTER);
                    labels[i].setFont(new Font("ALGERIAN", Font.BOLD, 50));
                    c = false;
                    repaint();
                } else {
                    labels[i].setText("O");
                    labels[i].setHorizontalAlignment(JLabel.CENTER);
                    labels[i].setFont(new Font("ALGERIAN", Font.BOLD, 50));
                    c = true;
                    repaint();
                }
                if (hasWinner(labels)) {
                    result.setText(getWinner(labels) + " Wins!");
                    result.setHorizontalAlignment(JLabel.CENTER);
                    result.setVisible(true);
                    check = true;
                } else if (gameOver(labels)) {
                    result.setText("Game is a Draw");
                    result.setVisible(true);
                }
                break;
            }
        }
    }
}