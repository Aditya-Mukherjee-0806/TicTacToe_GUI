import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTFrame extends JFrame implements ActionListener {
    JButton pvcButton = new JButton();
    JButton pvpButton = new JButton();
    PvC_Panel pvcPanel = new PvC_Panel();
    PvP_Panel pvpPanel = new PvP_Panel();

    TTTFrame() {
        pvcButton.setBounds(50, 25, 200, 100);
        pvcButton.setText("Single Player");
        pvcButton.setFont(new Font("default", Font.BOLD, 18));
        pvcButton.setFocusable(false);
        pvcButton.setHorizontalTextPosition(JButton.CENTER);
        pvcButton.setVerticalTextPosition(JButton.CENTER);
        pvcButton.addActionListener(this);

        pvpButton.setBounds(250, 25, 200, 100);
        pvpButton.setText("Multi Player");
        pvpButton.setFont(new Font("default", Font.BOLD, 18));
        pvpButton.setFocusable(false);
        pvpButton.setHorizontalTextPosition(JButton.CENTER);
        pvpButton.setVerticalTextPosition(JButton.CENTER);
        pvpButton.addActionListener(this);

        this.setLayout(null);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(pvcButton);
        this.add(pvpButton);
        this.add(pvpPanel);
        this.add(pvcPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pvcButton) {
            pvcPanel.setVisible(true);
            pvcButton.setVisible(false);
            pvpButton.setVisible(false);
        } else if (e.getSource() == pvpButton)
            pvpPanel.setVisible(true);
        pvcButton.setVisible(false);
        pvpButton.setVisible(false);
    }
}