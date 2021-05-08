package com.footforwarddevelopmentconsultancy.mediscreen.model;

import javax.validation.constraints.NotBlank;

public class Note {
    private String id;
    private int patientId;
    @NotBlank(message = "Notes/Recommendations are mandatory")
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
