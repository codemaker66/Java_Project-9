package com.footforwarddevelopmentconsultancy.mediscreen.controller;

import com.footforwarddevelopmentconsultancy.mediscreen.exceptions.ResourceException;
import com.footforwarddevelopmentconsultancy.mediscreen.model.Note;
import com.footforwarddevelopmentconsultancy.mediscreen.model.Patient;
import com.footforwarddevelopmentconsultancy.mediscreen.service.PatientService;
import com.footforwarddevelopmentconsultancy.mediscreen.service.PractitionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class PractitionerController {

    @Autowired
    PractitionerService practitionerService;

    @Autowired
    PatientService patientService;


    @GetMapping(value = "/practitionerNotesHistory/{id}")
    public String getPractitionerNotesHistory(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.findPatientById(id);
        if (patient == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "There are no patient with the id : " + id + " in the database");
        }
        model.addAttribute("notes", practitionerService.findPractitionerNotesHistoryById(id))
        .addAttribute("patient", patient);

        return "practitionerNotes/list";
    }

    @GetMapping("/practitionerNotes/add/{id}")
    public String displayTheAddForm(@PathVariable("id") int id, Model model) {
        Patient patient = patientService.findPatientById(id);
        if (patient == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "There are no patient with the id : " + id + " in the database");
        }
        Note note = new Note();
        note.setPatientId(patient.getId());
        model.addAttribute("note", note);
        return "practitionerNotes/add";
    }

    @PostMapping("/practitionerNotes/add")
    public String addPractitionerNotes(@Valid Note note, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            practitionerService.savePractitionerNotes(note);
            return "redirect:/practitionerNotesHistory/" + note.getPatientId();
        }
        return "practitionerNotes/add";


    }

    @GetMapping(value = "/practitionerNotes/update/{id}")
    public String displayTheUpdateForm(@PathVariable("id") String id, Model model) {
        Note note = practitionerService.findPractitionerNotesById(id);
        if (note == null) {
            throw new ResourceException(HttpStatus.NOT_FOUND, "There are no practitioner notes/recommendations with the id : " + id + " in the database");
        }
        model.addAttribute("note", note);
        return "practitionerNotes/update";
    }

    @PostMapping(value = "/practitionerNotes/update/{id}")
    public String updatePractitionerNotes(@Valid Note note, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "practitionerNotes/update";
        }
        practitionerService.updatePractitionerNotes(note);
        return "redirect:/practitionerNotesHistory/" + note.getPatientId();
    }
}
