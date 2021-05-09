package com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice.service;

import com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice.model.Output;
import com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice.model.PatientMedicalRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

@Service
public class DiabetesAnticipatorService {

    private final List<String> triggerTermsList = Arrays.asList("Hémoglobine A1C", "Microalbumine", "Taille", "Poids", "Fumeur", "Anormal", "Cholestérol", "Vertige", "Rechute", "Réaction", "Anticorps");

    public Output getPatientDiabetesAssessment(PatientMedicalRecord patientMedicalRecord) {
        Output output = new Output();

        output.setName(patientMedicalRecord.getName());
        output.setFamilyName(patientMedicalRecord.getFamilyName());

        LocalDate localDate = patientMedicalRecord.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();
        int age = Period.between(localDate, now).getYears();

        output.setAge(age);

        int triggerNumber = 0;

        for (String note : patientMedicalRecord.getNote()) {
            for (String triggerTerm : triggerTermsList) {
                if (note.toLowerCase().contains(triggerTerm.toLowerCase())) {
                    triggerNumber++;
                }
            }
        }

        if (triggerNumber == 0) {
            output.setDiabetesAssessment("None");
        } else if (triggerNumber == 2 && age > 30) {
            output.setDiabetesAssessment("Borderline");
        } else if (triggerNumber == 3 && age < 30 && patientMedicalRecord.getGender().equals("male")) {
            output.setDiabetesAssessment("In Danger");
        } else if (triggerNumber == 4 && age < 30 && patientMedicalRecord.getGender().equals("female")) {
            output.setDiabetesAssessment("In Danger");
        } else if (triggerNumber == 6 && age > 30) {
            output.setDiabetesAssessment("In Danger");
        } else if (triggerNumber == 5 && age < 30 && patientMedicalRecord.getGender().equals("male")) {
            output.setDiabetesAssessment("Early onset");
        } else if (triggerNumber == 7 && age < 30 && patientMedicalRecord.getGender().equals("female")) {
            output.setDiabetesAssessment("Early onset");
        } else if (triggerNumber >= 8 && age > 30) {
            output.setDiabetesAssessment("Early onset");
        } else {
            output.setDiabetesAssessment("Not enough data for assessment");
        }

        return output;
    }
}
