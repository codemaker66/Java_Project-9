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

    public List<Patient> findAllPatients() { return patientRepository.retrieveAllPatients(); }

    public Patient findPatientById(int id) { return patientRepository.findById(id); }

    public void updatePatientData(Patient patient) {
        patientRepository.save(patient);
    }

    public void registerThePatient(Patient patient) {
        patientRepository.save(patient);
    }
}
