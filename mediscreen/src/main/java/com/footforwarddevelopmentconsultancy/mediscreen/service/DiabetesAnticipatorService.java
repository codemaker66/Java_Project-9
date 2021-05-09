package com.footforwarddevelopmentconsultancy.mediscreen.service;

import com.footforwarddevelopmentconsultancy.mediscreen.model.Note;
import com.footforwarddevelopmentconsultancy.mediscreen.model.Output;
import com.footforwarddevelopmentconsultancy.mediscreen.model.PatientMedicalRecord;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DiabetesAnticipatorService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Output getPatientDiabetesAssessment(PatientMedicalRecord patientMedicalRecord) {
        String URL = "http://diabetes-anticipator-microservice-server:8083/getPatientDiabetesAssessment";
        HttpEntity<PatientMedicalRecord> entity = new HttpEntity<>(patientMedicalRecord, null);
        ResponseEntity<Output> response = restTemplate.exchange(URL, HttpMethod.POST, entity, Output.class);
        return response.getBody();
    }
}
