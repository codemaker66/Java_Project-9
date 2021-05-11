package com.footforwarddevelopmentconsultancy.mediscreen.controller;

import com.footforwarddevelopmentconsultancy.mediscreen.model.Patient;
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

    /**
     * This method call the PatientService to find all patients.
     *
     * @param model represent Java-5-specific interface that defines a holder for model attributes.
     * @return the view that display the list of all patients.
     */
    @GetMapping(value = "/patients")
    public String getAllPatients(Model model) {
        model.addAttribute("patients", patientService.findAllPatients());
        return "patient/list";
    }

    /**
     * This method display the add form for the user.
     *
     * @param model represent Java-5-specific interface that defines a holder for model attributes.
     * @return the view that display the add form.
     */
    @GetMapping("/patient/add")
    public String displayTheAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient/add";
    }

    /**
     * This method call the PatientService to register the patient.
     *
     * @param patient is an object of type Patient.
     * @param bindingResult is a general interface that represents binding results.
     * @return a redirection to the patients list if the request was successful.
     */
    @PostMapping("/patient/register")
    public String addAPatient(@Valid Patient patient, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            patientService.registerThePatient(patient);
            return "redirect:/patients";
        }
        return "patient/add";
    }

    /**
     * This method display the update form for the user.
     *
     * @param id is the id of the patient.
     * @param model represent Java-5-specific interface that defines a holder for model attributes.
     * @return the view that display the update form.
     */
    @GetMapping(value = "/patient/update/{id}")
    public String displayTheUpdateForm(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.findPatientById(id);
        if (patient == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "There are no patient with the id : " + id + " in the database");
        }
        model.addAttribute("patient", patient);
        return "patient/update";
    }

    /**
     * This method call the PatientService to update patient data.
     *
     * @param patient is an object of type Patient.
     * @param bindingResult is a general interface that represents binding results.
     * @return a redirection to the patients list if the request was successful.
     */
    @PostMapping(value = "/patient/update")
    public String updateAPatient(@Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "patient/update";
        }
        patientService.updatePatientData(patient);
        return "redirect:/patients";
    }
}
