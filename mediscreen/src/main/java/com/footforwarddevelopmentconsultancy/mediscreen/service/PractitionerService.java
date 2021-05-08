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

    public List<Note> findPractitionerNotesHistoryById(int id) {
        String URL = "http://practitioner-microservice-server:8082/practitionerNotesHistory/" + id;
        ResponseEntity<List<Note>> response = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Note>>(){});
        return response.getBody();
    }

    public void savePractitionerNotes(Note note) {
        String URL = "http://practitioner-microservice-server:8082/practitionerNotes/add";
        HttpEntity<Note> entity = new HttpEntity<>(note, null);
        restTemplate.exchange(URL, HttpMethod.POST, entity, Note.class);
    }

    public Note findPractitionerNotesById(String id) {
        String URL = "http://practitioner-microservice-server:8082/practitionerNotes/" + id;
        ResponseEntity<Note> response = restTemplate.exchange(URL, HttpMethod.GET, null, Note.class);
        return response.getBody();
    }

    public void updatePractitionerNotes(Note note) {
        String URL = "http://practitioner-microservice-server:8082/practitionerNotes/update";
        HttpEntity<Note> entity = new HttpEntity<>(note, null);
        restTemplate.exchange(URL, HttpMethod.POST, entity, Note.class);
    }
}
