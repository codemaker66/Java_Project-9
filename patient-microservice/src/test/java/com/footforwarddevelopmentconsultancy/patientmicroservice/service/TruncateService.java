package com.footforwarddevelopmentconsultancy.patientmicroservice.service;

import com.footforwarddevelopmentconsultancy.patientmicroservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruncateService {

    @Autowired
    PatientRepository patientRepository;

    public void truncatePatientsTable() {
        patientRepository.PatientsTable();
    }
}
