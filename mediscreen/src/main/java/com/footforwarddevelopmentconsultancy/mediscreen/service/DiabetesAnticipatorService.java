package com.footforwarddevelopmentconsultancy.mediscreen.service;

import com.footforwarddevelopmentconsultancy.mediscreen.model.Output;
import com.footforwarddevelopmentconsultancy.mediscreen.model.PatientMedicalRecord;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DiabetesAnticipatorService {

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * This method call the microservice to retrieve the patient diabetes assessment.
     *
     * @param patientMedicalRecord is an object of type PatientMedicalRecord.
     * @return an object of type Output.
     */
    public Output getPatientDiabetesAssessment(PatientMedicalRecord patientMedicalRecord) {
        String url = "http://diabetes-anticipator-microservice-server:8083/getPatientDiabetesAssessment";
        HttpEntity<PatientMedicalRecord> entity = new HttpEntity<>(patientMedicalRecord, null);
        ResponseEntity<Output> response = restTemplate.exchange(url, HttpMethod.POST, entity, Output.class);
        return response.getBody();
    }
}
