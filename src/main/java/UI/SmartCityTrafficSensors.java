package UI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
@Table(name = "SmartCityTrafficSensors")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class SmartCityTrafficSensors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SensorId;

    private String DistrictName;
    private String SensorType;
    private LocalDate MeasurmentData;
    private int MeasurmentHour;
    private int VehicleCount;
    private double AverageSpeedKmh;
    private int AirQualityIndex;
    private double NoiseLevelDb;
    private String TrafficStatus;

}
