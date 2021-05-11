package com.footforwarddevelopmentconsultancy.practitionermicroservice.repository;

import com.footforwarddevelopmentconsultancy.practitionermicroservice.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PractitionerRepository extends MongoRepository<Note, Integer> {

    /**
     * This method retrieve practitioner notes by patient id.
     *
     * @param id is the id of the patient.
     * @return a list that contain all the practitioner notes.
     */
    @Query("{'patient_id' : ?0}")
    List<Note> findById(int id);

    /**
     * This method retrieve practitioner notes by it's id.
     *
     * @param id is the id of the practitioner notes.
     * @return an object of type Note.
     */
    @Query("{'id' : ?0}")
    Note findPractitionerNotesById(String id);
}
