package com.footforwarddevelopmentconsultancy.patientmicroservice.controller;

import com.footforwarddevelopmentconsultancy.patientmicroservice.entity.Patient;
import com.footforwarddevelopmentconsultancy.patientmicroservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(value = "/patients")
    public List<Patient> getAllPatients() {
        return patientService.findAllPatients();
    }

    @GetMapping(value = "/find/patient/{id}")
    public Patient getPatient(@PathVariable("id") int id) {
        return patientService.findPatientById(id);
    }

    @PostMapping("/patient/register")
    public void addAPatient(@RequestBody Patient patient) {
        patientService.registerThePatient(patient);
    }

    @PostMapping(value = "/patient/update")
    public void updateAPatient(@RequestBody Patient patient) {
        patientService.updatePatientData(patient);
    }
}
