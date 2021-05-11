package com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice;

import com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice.model.Output;
import com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice.model.PatientMedicalRecord;
import com.footforwarddevelopmentconsultancy.diabetesanticipatormicroservice.service.DiabetesAnticipatorService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiabetesAnticipatorServiceTest {

    @Autowired
    DiabetesAnticipatorService diabetesAnticipatorService;

    @Test
    void getPatientDiabetesAssessment() {
        // Given
        PatientMedicalRecord patientMedicalRecord = new PatientMedicalRecord();
        patientMedicalRecord.setName("Tom");
        patientMedicalRecord.setFamilyName("Sawyer");
        patientMedicalRecord.setDateOfBirth(LocalDate.of(1980, 8, 22));
        patientMedicalRecord.setGender("male");
        List<String> notes = Arrays.asList("Hémoglobine A1C", "Microalbumine", "Taille", "Poids", "Fumeur", "Anormal", "Cholestérol", "Vertige");
        patientMedicalRecord.setNote(notes);

        // When
        Output output = diabetesAnticipatorService.getPatientDiabetesAssessment(patientMedicalRecord);

        // Then
        LocalDate now = LocalDate.now();
        int age = Period.between(patientMedicalRecord.getDateOfBirth(), now).getYears();
        assertThat(output.getName()).isEqualTo("Tom");
        assertThat(output.getFamilyName()).isEqualTo("Sawyer");
        assertThat(output.getAge()).isEqualTo(age);
        assertThat(output.getDiabetesAssessment()).isEqualTo("Early onset");
    }
}
