package com.footforwarddevelopmentconsultancy.mediscreen.service;

import com.footforwarddevelopmentconsultancy.mediscreen.model.Note;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class PractitionerService {

    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * This method call the microservice to find practitioner notes history by the patien id.
     *
     * @param id is the id of the patient.
     * @return a list that contain all the practitioner notes.
     */
    public List<Note> findPractitionerNotesHistoryById(int id) {
        String url = "http://practitioner-microservice-server:8082/practitionerNotesHistory/" + id;
        ResponseEntity<List<Note>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Note>>(){});
        return response.getBody();
    }

    /**
     * This method call the microservice to save practitioner notes.
     *
     * @param note is an object of type Note.
     */
    public void savePractitionerNotes(Note note) {
        String url = "http://practitioner-microservice-server:8082/practitionerNotes/add";
        HttpEntity<Note> entity = new HttpEntity<>(note, null);
        restTemplate.exchange(url, HttpMethod.POST, entity, Note.class);
    }

    /**
     * This method call the microservice to find practitioner notes by id.
     *
     * @param id is the id of the practitioner notes.
     * @return an object of type Note.
     */
    public Note findPractitionerNotesById(String id) {
        String url = "http://practitioner-microservice-server:8082/practitionerNotes/" + id;
        ResponseEntity<Note> response = restTemplate.exchange(url, HttpMethod.GET, null, Note.class);
        return response.getBody();
    }

    /**
     * This method call the microservice to update practitioner notes.
     *
     * @param note is an object of type Note.
     */
    public void updatePractitionerNotes(Note note) {
        String url = "http://practitioner-microservice-server:8082/practitionerNotes/update";
        HttpEntity<Note> entity = new HttpEntity<>(note, null);
        restTemplate.exchange(url, HttpMethod.POST, entity, Note.class);
    }
}
