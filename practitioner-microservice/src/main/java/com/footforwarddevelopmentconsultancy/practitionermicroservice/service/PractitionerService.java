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

    public List<Note> findPractitionerNotesHistoryById(int id) {
        return practitionerRepository.findById(id);
    }

    public void savePractitionerNotes(Note note) {
        practitionerRepository.save(note);
    }

    public Note findPractitionerNotesById(String id) {
        return practitionerRepository.findPractitionerNotesById(id);
    }

    public void updatePractitionerNotes(Note note) {
        practitionerRepository.save(note);
    }
}
