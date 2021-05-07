package com.footforwarddevelopmentconsultancy.mediscreen.controller;

import com.footforwarddevelopmentconsultancy.mediscreen.entity.Patient;
import com.footforwarddevelopmentconsultancy.mediscreen.exceptions.ResourceException;
import com.footforwarddevelopmentconsultancy.mediscreen.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(value = "/patients")
    public String getAllPatients(Model model) {
        model.addAttribute("patients", patientService.findAllPatients());
        return "patient/list";
    }

    @GetMapping("/patient/add")
    public String displayTheAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient/add";
    }

    @PostMapping("/patient/register")
    public String addAPatient(@Valid Patient patient, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            patientService.registerThePatient(patient);
            return "redirect:/patients";
        }
        return "patient/add";
    }

    @GetMapping(value = "/patient/update/{id}")
    public String displayTheUpdateForm(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.findPatientById(id);
        if (patient == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "There are no patient with the id : " + id + " in the database");
        }
        model.addAttribute("patient", patient);
        return "patient/update";
    }

    @PostMapping(value = "/patient/update/{id}")
    public String updateAPatient(@Valid Patient patient, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "patient/update";
        }
        patientService.updatePatientData(patient);
        return "redirect:/patients";
    }


}
