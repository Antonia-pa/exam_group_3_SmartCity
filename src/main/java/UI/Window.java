package UI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Window extends JFrame {

    private ChartPanel chartPanel;
    private List<SmartCityTrafficSensors> data;

    public Window() {

        setTitle("Sensors");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // Header
        HelperHeader header = new HelperHeader("Sensors");
        add(header, BorderLayout.NORTH);

        // Daten laden
        data = SmartCityTrafficSensorsUtility.getSensors();

        // Chart bauen
        chartPanel = buildChart(data);
        add(chartPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBackground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 70, 180));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(2, 0, 2, 0);

        HelperButtonStyle pdfButton = new HelperButtonStyle("Export PDF", 180);
        HelperButtonStyle jsonButton = new HelperButtonStyle("Export JSON", 180);

        gbc.gridy = 0;
        buttonPanel.add(pdfButton, gbc);
        gbc.gridy = 1;
        buttonPanel.add(jsonButton, gbc);

        southPanel.add(buttonPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);

        // Button Actions
        pdfButton.addActionListener(e -> exportPDF());
        jsonButton.addActionListener(e -> exportJSON());

    }

    private ChartPanel buildChart(List<SmartCityTrafficSensors> data) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Map<String, Long> grouped = data.stream().collect(Collectors.groupingBy(SmartCityTrafficSensors::getDistrictName, Collectors.counting()));

        grouped.forEach((category, count) ->
                dataset.addValue(count, "Sensors", category));

        JFreeChart chart = ChartFactory.createBarChart(
                "Vehicle Count per District",
                "District",
                "Count",
                dataset
        );

        return new ChartPanel(chart);
    }

    private void exportPDF() {

        try {
            java.nio.file.Files.createDirectories(java.nio.file.Path.of("output"));
            String filePath = "output/chart_" + java.time.LocalDate.now() + ".pdf";

            java.awt.image.BufferedImage image = chartPanel.getChart()
                    .createBufferedImage(1000, 600);

            com.lowagie.text.Document document = new com.lowagie.text.Document(
                    com.lowagie.text.PageSize.A4.rotate());
            com.lowagie.text.pdf.PdfWriter.getInstance(
                    document, new java.io.FileOutputStream(filePath));
            document.open();

            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            javax.imageio.ImageIO.write(image, "png", baos);
            com.lowagie.text.Image pdfImage = com.lowagie.text.Image
                    .getInstance(baos.toByteArray());
            pdfImage.scaleToFit(800, 500);
            document.add(pdfImage);

            document.close();
            JOptionPane.showMessageDialog(null, "PDF saved: " + filePath);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void exportJSON() {

        try {
            java.nio.file.Files.createDirectories(java.nio.file.Path.of("output"));
            String filePath = "output/data_" + java.time.LocalDate.now() + ".json";

            com.fasterxml.jackson.databind.ObjectMapper mapper =
                    new com.fasterxml.jackson.databind.ObjectMapper();
            mapper.registerModule(
                    new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
            mapper.writeValue(new java.io.File(filePath), data);

            JOptionPane.showMessageDialog(null, "JSON saved: " + filePath);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

}
