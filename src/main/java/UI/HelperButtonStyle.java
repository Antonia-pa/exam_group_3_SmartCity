package UI;

import javax.swing.*;
import java.awt.*;

public class HelperButtonStyle extends JButton {

    public HelperButtonStyle(String text, int width) {

        setText("<html><center>" + text + "</center></html>");

        setFont(new Font("Arial", Font.BOLD, 14));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setBorder(BorderFactory.createLineBorder(new Color(45, 68, 94), 2));

        setPreferredSize(new Dimension(width, 50));
        setMaximumSize(new Dimension(width, 50));

    }

}
