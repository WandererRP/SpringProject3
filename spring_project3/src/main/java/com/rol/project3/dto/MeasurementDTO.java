package com.rol.project3.dto;

import com.rol.project3.models.Sensor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

/**
 * @author Roland Pilpani 14.09.2022
 */

public class MeasurementDTO {
    @NotNull(message = "Значение температуры не должно быть пустым")
    @Min(value = -100, message = "Значение температуры должно быть от -100 до 100")
    @Max(value = 100, message = "Значение температуры должно быть от -100 до 100")
    private Double value;

    @NotNull(message = "Данные о дожде не должны отсутствовать")
    private Boolean raining;

    @NotNull(message = "Данные о сенсоре не должны отсутствовать")
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
}
