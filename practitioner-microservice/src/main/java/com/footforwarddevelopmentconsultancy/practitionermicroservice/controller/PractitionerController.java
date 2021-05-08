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

    @GetMapping(value = "/practitionerNotesHistory/{id}")
    public List<Note> getPractitionerNotesHistory(@PathVariable("id") int id) {
        return practitionerService.findPractitionerNotesHistoryById(id);
    }

    @PostMapping("/practitionerNotes/add")
    public void addPractitionerNotes(@RequestBody Note note) {
        practitionerService.savePractitionerNotes(note);
    }

    @GetMapping(value = "/practitionerNotes/{id}")
    public Note getPractitionerNotes(@PathVariable("id") String id) {
        return practitionerService.findPractitionerNotesById(id);
    }

    @PostMapping("/practitionerNotes/update")
    public void updatePractitionerNotes(@RequestBody Note note) {
        practitionerService.updatePractitionerNotes(note);
    }
}
