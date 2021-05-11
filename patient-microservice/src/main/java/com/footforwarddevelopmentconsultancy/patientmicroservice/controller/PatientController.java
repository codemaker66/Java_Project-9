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

    /**
     * This method call the PatientService to get all patients.
     *
     * @return a list that contain all the patients.
     */
    @GetMapping(value = "/patients")
    public List<Patient> getAllPatients() {
        return patientService.findAllPatients();
    }

    /**
     * This method call the PatientService to get a patient by his id.
     *
     * @param id is the id of the patient.
     * @return an object of type Patient.
     */
    @GetMapping(value = "/find/patientById/{id}")
    public Patient getPatient(@PathVariable("id") int id) {
        return patientService.findPatientById(id);
    }

    /**
     * This method call the PatientService to add a patient.
     *
     * @param patient is an object of type Patient.
     */
    @PostMapping("/patient/register")
    public void addAPatient(@RequestBody Patient patient) {
        patientService.registerThePatient(patient);
    }

    /**
     * This method call the PatientService to update a patient.
     *
     * @param patient is an object of type Patient.
     */
    @PostMapping(value = "/patient/update")
    public void updateAPatient(@RequestBody Patient patient) {
        patientService.updatePatientData(patient);
    }

    /**
     * This method call the PatientService to get a patient by his family name.
     *
     * @param familyName is the family name of the patient.
     * @return an object of type Patient.
     */
    @GetMapping(value = "/find/patientByFamilyName/{familyName}")
    public Patient getPatient(@PathVariable("familyName") String familyName) {
        return patientService.findPatientByFamilyName(familyName);
    }
}
