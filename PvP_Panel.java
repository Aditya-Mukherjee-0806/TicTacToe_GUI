import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PvP_Panel extends JPanel implements ActionListener {
    JLabel[] labels = new JLabel[9];
    JButton[] buttons = new JButton[9];
    boolean c = true;

    PvP_Panel() {
        for (int i = 0; i < 9; i++) {
            labels[i] = new JLabel();
            buttons[i] = new JButton();
        }

        labels[0].setBounds(0, 0, 100, 100);
        labels[1].setBounds(0, 100, 100, 100);
        labels[2].setBounds(0, 200, 100, 100);
        labels[3].setBounds(100, 0, 100, 100);
        labels[4].setBounds(100, 100, 100, 100);
        labels[5].setBounds(100, 200, 100, 100);
        labels[6].setBounds(200, 0, 100, 100);
        labels[7].setBounds(200, 100, 100, 100);
        labels[8].setBounds(200, 200, 100, 100);

        buttons[0].setBounds(0, 0, 100, 100);
        buttons[1].setBounds(0, 100, 100, 100);
        buttons[2].setBounds(0, 200, 100, 100);
        buttons[3].setBounds(100, 0, 100, 100);
        buttons[4].setBounds(100, 100, 100, 100);
        buttons[5].setBounds(100, 200, 100, 100);
        buttons[6].setBounds(200, 0, 100, 100);
        buttons[7].setBounds(200, 100, 100, 100);
        buttons[8].setBounds(200, 200, 100, 100);

        for (int i = 0; i < 9; i++) {
            buttons[i].addActionListener(this);
        }

        this.setLayout(null);
        this.setBounds(100, 100, 300, 300);
        for (int i = 0; i < 9; i++) {
            this.add(labels[i]);
            this.add(buttons[i]);
        }
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
            }
        }
    }
}
