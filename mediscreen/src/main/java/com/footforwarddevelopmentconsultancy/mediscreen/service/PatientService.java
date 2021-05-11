package com.footforwarddevelopmentconsultancy.mediscreen.service;

import com.footforwarddevelopmentconsultancy.mediscreen.model.Patient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class PatientService {

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * This method call the microservice to retrieve all patients.
     *
     * @return a list that contain all the patients.
     */
    public List<Patient> findAllPatients() {
        String url = "http://patient-microservice-server:8081/patients";
        ResponseEntity<List<Patient>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Patient>>(){});
        return response.getBody();
    }

    /**
     * This method call the microservice to find a patient by his id.
     *
     * @param id is the id of the patient.
     * @return an object of type Patient.
     */
    public Patient findPatientById(int id) {
        String url = "http://patient-microservice-server:8081/find/patientById/" + id;
        ResponseEntity<Patient> response = restTemplate.exchange(url, HttpMethod.GET, null, Patient.class);
        return response.getBody();
    }

    /**
     * This method call the microservice to register the patient.
     *
     * @param patient is an object of type Patient.
     */
    public void registerThePatient(Patient patient) {
        String url = "http://patient-microservice-server:8081/patient/register";
        HttpEntity<Patient> entity = new HttpEntity<>(patient, null);
        restTemplate.exchange(url, HttpMethod.POST, entity, Patient.class);
    }

    /**
     * This method call the microservice to update patient data.
     *
     * @param patient is an object of type Patient.
     */
    public void updatePatientData(Patient patient) {
        String url = "http://patient-microservice-server:8081/patient/update";
        HttpEntity<Patient> entity = new HttpEntity<>(patient, null);
        restTemplate.exchange(url, HttpMethod.POST, entity, Patient.class);
    }

    /**
     * This method call the microservice to find a patient by his family name.
     *
     * @param familyName is the family name of the patient.
     * @return an object of type Patient.
     */
    public Patient findPatientByFamilyName(String familyName) {
        String url = "http://patient-microservice-server:8081/find/patientByFamilyName/" + familyName;
        ResponseEntity<Patient> response = restTemplate.exchange(url, HttpMethod.GET, null, Patient.class);
        return response.getBody();
    }
}
