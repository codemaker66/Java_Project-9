package com.footforwarddevelopmentconsultancy.practitionermicroservice.repository;

import com.footforwarddevelopmentconsultancy.practitionermicroservice.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PractitionerRepository extends MongoRepository<Note, Integer> {

    @Query("{'patient_id' : ?0}")
    List<Note> findById(int id);

    @Query("{'id' : ?0}")
    Note findPractitionerNotesById(String id);
}
