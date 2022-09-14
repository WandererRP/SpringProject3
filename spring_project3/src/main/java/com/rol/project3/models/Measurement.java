package com.rol.project3.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * @author Roland Pilpani 14.09.2022
 */
@Entity
@Table(name = "Measurement")
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Значение температуры не должно быть пустым")
    @Min(value = -100, message = "Значение температуры должно быть от -100 до 100")
    @Max(value = 100, message = "Значение температуры должно быть от -100 до 100")
    @Column(name = "value")
    private Double value;

    @NotNull(message = "Данные о дожде не должны отсутствовать")
    @Column(name = "is_raining")
    private Boolean raining;

    @NotNull(message = "Время должно быть указано")
    @Column(name = "time")
    private LocalDateTime time;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    @NotNull(message = "Данные о сенсоре не должны отсутствовать")
    private Sensor sensor;

    public Measurement() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
