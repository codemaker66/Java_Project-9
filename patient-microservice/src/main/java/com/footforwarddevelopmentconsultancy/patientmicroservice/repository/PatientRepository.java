package com.footforwarddevelopmentconsultancy.patientmicroservice.repository;

import com.footforwarddevelopmentconsultancy.patientmicroservice.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    @Query(value = "SELECT * FROM patients", nativeQuery = true)
    List<Patient> retrieveAllPatients();

    @Query(value = "SELECT * FROM patients WHERE patients.id = :id", nativeQuery = true)
    Patient findById(int id);
}
