# Technical Documentation - Smart City Traffic Sensors

## Purpose of the Application
The Smart City Traffic Sensors application is a Java-based desktop utility designed to visualize and export traffic sensor data from a smart city environment. It provides a graphical overview of vehicle counts across different districts and allows users to export this data for further analysis.

## Technologies and Libraries Used
- **Java 17**: Core programming language.
- **Maven**: Project management and build automation.
- **Swing (Java Foundation Classes)**: Used for building the Graphical User Interface (GUI).
- **Hibernate ORM**: Used for database connectivity and object-relational mapping.
- **Microsoft SQL Server JDBC Driver**: Connects the application to the SQL Server database.
- **JFreeChart**: Used for generating the bar charts.
- **OpenPDF (LibrePDF)**: Used for generating PDF reports containing the charts.
- **Jackson (databind/jsr310)**: Used for JSON serialization of the sensor data.
- **Lombok**: Used to reduce boilerplate code (getters, setters, etc.) in entity classes.

## Structure of the Main Classes
- **`UI.Application`**: The entry point of the application which initializes and displays the main window.
- **`UI.Window`**: The main GUI class that handles the layout, chart rendering, and button actions for exports.
- **`UI.SmartCityTrafficSensors`**: An entity class representing the sensor data model.
- **`UI.SmartCityTrafficSensorsUtility`**: Provides helper methods to fetch sensor data from the database using Hibernate.
- **`UI.HibernateUtil`**: Manages the Hibernate `SessionFactory` and configuration.
- **Helper Classes**: `HelperHeader`, `HelperButtonStyle`, `ConnectionCheckLight`, and `DatabaseDiagnostics` assist with UI styling and health checks.

## Database Mapping
The application uses Hibernate to map the `SmartCityTrafficSensors` class to the `SmartCityTrafficSensors` table in a Microsoft SQL Server database.
- **Table Name**: `SmartCityTrafficSensors`
- **Primary Key**: `SensorId` (Identity column)
- **Key Fields**: `DistrictName`, `SensorType`, `MeasurementDate`, `MeasurementHour`, `VehicleCount`, `AverageSpeedKmh`, `AirQualityIndex`, `NoiseLevelDb`, `TrafficStatus`.

## Functionality of the Chart
The application features a Bar Chart generated using **JFreeChart**. 
- It aggregates the sensor data to show the **Vehicle Count per District**.
- The chart is displayed in the center of the main window upon application startup.
- It provides a quick visual comparison of traffic volume across different city areas.

## Functionality of the PDF Export
- Users can click the "Export PDF" button to save the current chart.
- The application captures the chart as a buffered image.
- It then creates a PDF document in landscape orientation using **OpenPDF**.
- The PDF is saved in the `output/` directory with a filename format: `chart_YYYY-MM-DD.pdf`.

## Functionality of the JSON Export
- Users can click the "Export JSON" button to export the raw sensor data.
- The application uses **Jackson** to serialize the list of sensor objects into a JSON file.
- It handles Java 8 date/time types via the `JavaTimeModule`.
- The JSON file is saved in the `output/` directory with a filename format: `data_YYYY-MM-DD.json`.

## Instructions for Running the Application
1. **Prerequisites**: Ensure you have Java 17 and Maven installed.
2. **Database Access**: The application connects to a remote SQL Server. Ensure your environment has internet access and can connect to port 1433 of the target server.
3. **Build**: Run `mvn clean install` to download dependencies and compile the project.
4. **Run**: Execute the `main` method in `UI.Application`.
   - You can use the command: `mvn exec:java -Dexec.mainClass="UI.Application"`
