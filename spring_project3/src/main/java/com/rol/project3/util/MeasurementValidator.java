package com.rol.project3.util;

import com.rol.project3.models.Measurement;
import com.rol.project3.services.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Roland Pilpani 14.09.2022
 */

@Component
public class MeasurementValidator implements Validator {
    private final SensorsService sensorsService;

    @Autowired
    public MeasurementValidator(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Measurement measurement = (Measurement) target;
        if (measurement.getSensor() == null) {
            return;
        }
        if(sensorsService.findByName(measurement.getSensor().getName()).isEmpty()){
            errors.rejectValue("sensor", "", "Сенсор с таким именем не зарегистрирован в Базе Данных");
        }


    }
}
