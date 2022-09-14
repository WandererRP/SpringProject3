package dto;

/**
 * @author Roland Pilpani 14.09.2022
 */

public class MeasurementDTO {
    private Double value;
    private Boolean raining;
    private SensorDTO sensor;

    public MeasurementDTO() {
    }


    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public Boolean getRaining() {
        return raining;
    }
    public void setRaining(Boolean raining) {
        this.raining = raining;
    }
    public SensorDTO getSensor() {
        return sensor;
    }
    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return "Sensor name: " + sensor.getName() + "; " + "Temperature: " + value + "; " + "Raining: " + (raining?"Yes":"No");
    }


}
