package com.rol.project3.repositories;

import com.rol.project3.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Roland Pilpani 14.09.2022
 */

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {


}
