package com.rol.project3.util;

import com.rol.project3.models.Sensor;
import com.rol.project3.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Roland Pilpani 14.09.2022
 */
@Component
public class SensorValidator implements Validator {
    private final SensorsService sensorsService;

    @Autowired
    public SensorValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor =(Sensor) target;
        if(sensorsService.findByName(sensor.getName()).isPresent()) {
            errors.rejectValue("name", "", "This name is already exist");
        }


    }
}
