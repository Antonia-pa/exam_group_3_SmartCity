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



        // button
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 50, 80));

        HelperButtonStyle exportPdfButton = new HelperButtonStyle("Export PDF", 150);
        HelperButtonStyle exportJsonButton = new HelperButtonStyle("Export JSON", 150);

        buttonPanel.add(exportPdfButton, BorderLayout.EAST);
        buttonPanel.add(exportJsonButton, BorderLayout.EAST);


        add(buttonPanel, BorderLayout.SOUTH);






    }

}
