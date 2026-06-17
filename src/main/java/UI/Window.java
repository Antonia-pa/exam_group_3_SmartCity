package UI;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() {

        setTitle("Sensors");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        HelperHeader header = new HelperHeader("Sensors");
        add(header, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 80));

        JPanel buttonsRight = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonsRight.setBackground(Color.WHITE);

        HelperButtonStyle exportPdfButton = new HelperButtonStyle("Export PDF", 150);
        HelperButtonStyle exportJsonButton = new HelperButtonStyle("Export JSON", 150);

        buttonsRight.add(exportPdfButton);
        buttonsRight.add(exportJsonButton);

        buttonPanel.add(buttonsRight, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);



    }

}
