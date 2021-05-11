package com.footforwarddevelopmentconsultancy.practitionermicroservice.service;

import com.footforwarddevelopmentconsultancy.practitionermicroservice.entity.Note;
import com.footforwarddevelopmentconsultancy.practitionermicroservice.repository.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PractitionerService {

    @Autowired
    PractitionerRepository practitionerRepository;

    /**
     * This method call the PractitionerRepository to find practitioner notes history by patient id.
     *
     * @param id is the id of the patient.
     * @return a list that contain all the practitioner notes.
     */
    public List<Note> findPractitionerNotesHistoryById(int id) {
        return practitionerRepository.findById(id);
    }

    /**
     * This method call the PractitionerRepository to save practitioner notes.
     *
     * @param note is an object of type Note.
     */
    public void savePractitionerNotes(Note note) {
        practitionerRepository.save(note);
    }

    /**
     * This method call the PractitionerRepository to find practitioner notes by it's id.
     *
     * @param id is the id of the practitioner notes.
     * @return an object of type Note.
     */
    public Note findPractitionerNotesById(String id) {
        return practitionerRepository.findPractitionerNotesById(id);
    }

    /**
     * This method call the PractitionerRepository to update practitioner notes.
     *
     * @param note is an object of type Note.
     */
    public void updatePractitionerNotes(Note note) {
        practitionerRepository.save(note);
    }
}
