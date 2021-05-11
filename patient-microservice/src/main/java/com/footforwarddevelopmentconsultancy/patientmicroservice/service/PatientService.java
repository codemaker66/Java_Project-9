package com.footforwarddevelopmentconsultancy.patientmicroservice.service;

import com.footforwarddevelopmentconsultancy.patientmicroservice.entity.Patient;
import com.footforwarddevelopmentconsultancy.patientmicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    /**
     * This method call the PatientRepository to retrieve all patients.
     *
     * @return a list that contain all the patients.
     */
    public List<Patient> findAllPatients() { return patientRepository.retrieveAllPatients(); }

    /**
     * This method call the PatientRepository to find a patient by his id.
     *
     * @param id is the id of the patient.
     * @return an object of type Patient.
     */
    public Patient findPatientById(int id) { return patientRepository.findById(id); }

    /**
     * This method call the PatientRepository to register the patient.
     *
     * @param patient is an object of type Patient.
     */
    public void registerThePatient(Patient patient) { patientRepository.save(patient); }

    /**
     * This method call the PatientRepository to update patient data.
     *
     * @param patient is an object of type Patient.
     */
    public void updatePatientData(Patient patient) { patientRepository.save(patient); }

    /**
     * This method call the PatientRepository to find a patient by his family name.
     *
     * @param familyName is the family name of the patient.
     * @return an object of type Patient.
     */
    public Patient findPatientByFamilyName(String familyName) { return patientRepository.findByFamilyName(familyName); }
}
