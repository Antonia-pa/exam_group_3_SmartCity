package UI;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
@Table(name = "SmartCityTrafficSensors")

public class SmartCityTrafficSensors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SensorId;

    private String DistrictName;
    private String SensorType;
    private Date MeasurmentData;
    private int MeasurmentHour;
    private int VehicleCount;
    private double AverageSpeedKmh;
    private int AirQualityIndex;
    private double NoiseLevelDb;
    private String TrafficStatus;

}
