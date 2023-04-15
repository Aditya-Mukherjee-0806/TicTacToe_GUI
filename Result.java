import javax.swing.*;
import java.awt.*;

public class Result extends JLabel {
    Result() {
        this.setFont(new Font("default", Font.BOLD, 40));
        this.setBounds(0,285,300,150);
        this.setHorizontalTextPosition(JLabel.LEFT);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setVisible(false);
    }
}