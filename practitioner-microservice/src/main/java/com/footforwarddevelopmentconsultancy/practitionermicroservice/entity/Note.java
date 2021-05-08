package com.footforwarddevelopmentconsultancy.practitionermicroservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("notes")
public class Note {
    @Id
    private String id;
    @Field(name = "patient_id")
    private int patientId;
    @Field(name = "notes_and_recommendations")
    private String notesAndRecommendations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getNotesAndRecommendations() {
        return notesAndRecommendations;
    }

    public void setNotesAndRecommendations(String notesAndRecommendations) {
        this.notesAndRecommendations = notesAndRecommendations;
    }
}
