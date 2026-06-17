package UI;

import javax.swing.*;
import java.awt.*;

public class HelperHeader extends JPanel {

    public HelperHeader(String title) {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 30, 20));
        northPanel.setBackground(Color.WHITE);

        JLabel labelHeadline = new JLabel(title, SwingConstants.CENTER);
        labelHeadline.setFont(new Font("Arial", Font.BOLD, 24));
        labelHeadline.setForeground(Color.BLUE);
        northPanel.add(labelHeadline, BorderLayout.CENTER);

        add(northPanel, BorderLayout.NORTH);

    }

}
