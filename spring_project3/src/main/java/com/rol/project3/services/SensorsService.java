package com.rol.project3.services;

import com.rol.project3.models.Sensor;
import com.rol.project3.repositories.SensorsRepository;
import com.rol.project3.util.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Roland Pilpani 14.09.2022
 */
@Service
@Transactional(readOnly = true)
public class SensorsService {

    private final SensorsRepository sensorsRepository;

    @Autowired
    public SensorsService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }


    public Sensor findOne(int id){
        Optional<Sensor> foundService = sensorsRepository.findById(id);
        return foundService.orElseThrow(SensorNotFoundException::new);
    }

    public Optional<Sensor> findByName(String name){
        return sensorsRepository.findByName(name);

    }

    @Transactional
    public void save(Sensor sensor){
        sensorsRepository.save(sensor);
    }
}
