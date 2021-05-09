package com.footforwarddevelopmentconsultancy.mediscreen.controller;

import com.footforwarddevelopmentconsultancy.mediscreen.exceptions.ResourceException;
import com.footforwarddevelopmentconsultancy.mediscreen.model.Note;
import com.footforwarddevelopmentconsultancy.mediscreen.model.Output;
import com.footforwarddevelopmentconsultancy.mediscreen.model.Patient;
import com.footforwarddevelopmentconsultancy.mediscreen.model.PatientMedicalRecord;
import com.footforwarddevelopmentconsultancy.mediscreen.service.DiabetesAnticipatorService;
import com.footforwarddevelopmentconsultancy.mediscreen.service.PatientService;
import com.footforwarddevelopmentconsultancy.mediscreen.service.PractitionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DiabetesAnticipatorController {

    @Autowired
    DiabetesAnticipatorService diabetesAnticipatorService;

    @Autowired
    PatientService patientService;

    @Autowired
    PractitionerService practitionerService;

    @GetMapping(value = "/assessById/{id}")
    public String getPatientDiabetesAssessmentById(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.findPatientById(id);
        if (patient == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "There are no patient with the id : " + id + " in the database");
        }
        List<Note> note = practitionerService.findPractitionerNotesHistoryById(id);

        PatientMedicalRecord patientMedicalRecord = new PatientMedicalRecord();

        patientMedicalRecord.setName(patient.getName());
        patientMedicalRecord.setFamilyName(patient.getFamilyName());
        patientMedicalRecord.setDateOfBirth(patient.getDateOfBirth());
        patientMedicalRecord.setGender(patient.getGender());
        List<String> list = new ArrayList<>();
        for (Note value : note) {
            list.add(value.getNotesAndRecommendations());

        }
        patientMedicalRecord.setNote(list);

        Output output = diabetesAnticipatorService.getPatientDiabetesAssessment(patientMedicalRecord);

        model.addAttribute("output", output);

        return "patientDiabetesAssessment/output";
    }

    @GetMapping(value = "/assessByFamilyName/{familyName}")
    public String getPatientDiabetesAssessmentByFamilyName(@PathVariable("familyName") String familyName, Model model) {
        Patient patient = patientService.findPatientByFamilyName(familyName);
        if (patient == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "There are no patient with the family name : " + familyName + " in the database");
        }
        List<Note> note = practitionerService.findPractitionerNotesHistoryById(patient.getId());

        PatientMedicalRecord patientMedicalRecord = new PatientMedicalRecord();

        patientMedicalRecord.setName(patient.getName());
        patientMedicalRecord.setFamilyName(patient.getFamilyName());
        patientMedicalRecord.setDateOfBirth(patient.getDateOfBirth());
        patientMedicalRecord.setGender(patient.getGender());
        List<String> list = new ArrayList<>();
        for (Note value : note) {
            list.add(value.getNotesAndRecommendations());

        }
        patientMedicalRecord.setNote(list);

        Output output = diabetesAnticipatorService.getPatientDiabetesAssessment(patientMedicalRecord);

        model.addAttribute("output", output);

        return "patientDiabetesAssessment/output";
    }
}
