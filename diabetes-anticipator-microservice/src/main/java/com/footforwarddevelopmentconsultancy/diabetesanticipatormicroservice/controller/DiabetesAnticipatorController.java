package com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice.controller;

import com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice.model.Output;
import com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice.model.PatientMedicalRecord;
import com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice.service.DiabetesAnticipatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DiabetesAnticipatorController {

    @Autowired
    DiabetesAnticipatorService diabetesAnticipatorService;

    /**
     * This method call the DiabetesAnticipatorService to get patient diabetes assessment.
     *
     * @param patientMedicalRecord is an object of type PatientMedicalRecord.
     * @return an object of type Output.
     */
    @PostMapping(value = "/getPatientDiabetesAssessment")
    public Output getPatientDiabetesAssessment(@RequestBody PatientMedicalRecord patientMedicalRecord) {
        return diabetesAnticipatorService.getPatientDiabetesAssessment(patientMedicalRecord);
    }
}
