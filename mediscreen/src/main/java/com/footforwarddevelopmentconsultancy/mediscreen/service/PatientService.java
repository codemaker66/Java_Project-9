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

    public List<Patient> findAllPatients() {
        String URL = "http://patient-microservice-server:8081/patients";
        ResponseEntity<List<Patient>> response = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Patient>>(){});
        return response.getBody();
    }

    public Patient findPatientById(int id) {
        String URL = "http://patient-microservice-server:8081/find/patient/" + id;
        ResponseEntity<Patient> response = restTemplate.exchange(URL, HttpMethod.GET, null, Patient.class);
        return response.getBody();
    }

    public void updatePatientData(Patient patient) {
        String URL = "http://patient-microservice-server:8081/patient/register";
        HttpEntity<Patient> entity = new HttpEntity<>(patient, null);
        restTemplate.exchange(URL, HttpMethod.POST, entity, Patient.class);
    }

    public void registerThePatient(Patient patient) {
        String URL = "http://patient-microservice-server:8081/patient/update";
        HttpEntity<Patient> entity = new HttpEntity<>(patient, null);
        restTemplate.exchange(URL, HttpMethod.POST, entity, Patient.class);
    }

}
