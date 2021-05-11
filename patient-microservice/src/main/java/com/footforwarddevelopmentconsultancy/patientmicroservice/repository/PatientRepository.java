package com.footforwarddevelopmentconsultancy.patientmicroservice.repository;

import com.footforwarddevelopmentconsultancy.patientmicroservice.entity.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    /**
     * This method retrieve all the patients from the database.
     *
     * @return a list that contain all the patients.
     */
    @Query(value = "SELECT * FROM patients", nativeQuery = true)
    List<Patient> retrieveAllPatients();

    /**
     * This method retrieve a patient by his id from the database.
     *
     * @param id is the id of the patient.
     * @return an object of type Patient.
     */
    @Query(value = "SELECT * FROM patients WHERE patients.id = :id", nativeQuery = true)
    Patient findById(int id);

    /**
     * This method retrieve a patient by his family name from the database.
     *
     * @param familyName is the family name of the patient.
     * @return an object of type Patient.
     */
    @Query(value = "SELECT * FROM patients WHERE patients.family_name = :familyName", nativeQuery = true)
    Patient findByFamilyName(String familyName);

    /**
     * This method truncate the patients table from the database.
     */
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE patients", nativeQuery = true)
    void PatientsTable();
}
