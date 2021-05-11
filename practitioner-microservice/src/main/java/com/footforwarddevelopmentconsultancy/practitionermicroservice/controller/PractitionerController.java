package com.footforwarddevelopmentconsultancy.practitionermicroservice.controller;

import com.footforwarddevelopmentconsultancy.practitionermicroservice.entity.Note;
import com.footforwarddevelopmentconsultancy.practitionermicroservice.service.PractitionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PractitionerController {

    @Autowired
    PractitionerService practitionerService;

    /**
     * This method call the PractitionerService to get practitioner notes history.
     *
     * @param id is the id of the patient.
     * @return a list that contain all the practitioner notes.
     */
    @GetMapping(value = "/practitionerNotesHistory/{id}")
    public List<Note> getPractitionerNotesHistory(@PathVariable("id") int id) {
        return practitionerService.findPractitionerNotesHistoryById(id);
    }

    /**
     * This method call the PractitionerService to add practitioner notes.
     *
     * @param note is an object of type Note.
     */
    @PostMapping("/practitionerNotes/add")
    public void addPractitionerNotes(@RequestBody Note note) {
        practitionerService.savePractitionerNotes(note);
    }

    /**
     * This method call the PractitionerService to get practitioner notes.
     *
     * @param id is the id of the practitioner notes.
     * @return an object of type Note.
     */
    @GetMapping(value = "/practitionerNotes/{id}")
    public Note getPractitionerNotes(@PathVariable("id") String id) {
        return practitionerService.findPractitionerNotesById(id);
    }

    /**
     * This method call the PractitionerService to update practitioner notes.
     *
     * @param note is an object of type Note.
     */
    @PostMapping("/practitionerNotes/update")
    public void updatePractitionerNotes(@RequestBody Note note) {
        practitionerService.updatePractitionerNotes(note);
    }
}
