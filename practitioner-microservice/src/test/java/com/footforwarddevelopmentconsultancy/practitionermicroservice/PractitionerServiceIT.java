package com.footforwarddevelopmentconsultancy.practitionermicroservice;

import com.footforwarddevelopmentconsultancy.practitionermicroservice.entity.Note;
import com.footforwarddevelopmentconsultancy.practitionermicroservice.repository.PractitionerRepository;
import com.footforwarddevelopmentconsultancy.practitionermicroservice.service.TruncateService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PractitionerServiceIT {

    @Autowired
    PractitionerRepository practitionerRepository;

    @Autowired
    private TruncateService truncateService;

    private Note firstNote = new Note();
    private Note secondNote = new Note();

    @BeforeAll
    void init() {
        firstNote.setPatientId(1);
        firstNote.setNotesAndRecommendations("Some Notes And Recommendations 01");

        secondNote.setPatientId(2);
        secondNote.setNotesAndRecommendations("Some Notes And Recommendations 02");
    }

    @AfterAll
    void clearTable() {
        truncateService.truncateNotesTable();
    }

    @Test
    @Order(1)
    void savePractitionerNotes() {
        // When
        firstNote = practitionerRepository.save(firstNote);
        secondNote = practitionerRepository.save(secondNote);

        // Then
        assertThat(firstNote.getId()).isNotNull();
        assertThat(firstNote.getPatientId()).isEqualTo(1);
        assertThat(firstNote.getNotesAndRecommendations()).isEqualTo("Some Notes And Recommendations 01");
        assertThat(secondNote.getId()).isNotNull();
        assertThat(secondNote.getPatientId()).isEqualTo(2);
        assertThat(secondNote.getNotesAndRecommendations()).isEqualTo("Some Notes And Recommendations 02");
    }

    @Test
    @Order(2)
    void updatePractitionerNotes() {
        // Given
        firstNote.setNotesAndRecommendations("Some Notes 01");
        secondNote.setNotesAndRecommendations("Some Notes 02");

        // When
        firstNote = practitionerRepository.save(firstNote);
        secondNote = practitionerRepository.save(secondNote);

        // Then
        assertThat(firstNote.getNotesAndRecommendations()).isEqualTo("Some Notes 01");
        assertThat(secondNote.getNotesAndRecommendations()).isEqualTo("Some Notes 02");
    }

    @Test
    @Order(3)
    void findPractitionerNotesHistoryById() {
        // Given
        Note newNote = new Note();
        newNote.setPatientId(1);
        newNote.setNotesAndRecommendations("Some Notes And Recommendations 03");

        // When
        practitionerRepository.save(newNote);
        List<Note> notes = practitionerRepository.findById(1);

        // Then
        assertThat(notes.get(0).getPatientId()).isEqualTo(1);
        assertThat(notes.get(0).getNotesAndRecommendations()).isEqualTo("Some Notes 01");
        assertThat(notes.get(1).getPatientId()).isEqualTo(1);
        assertThat(notes.get(1).getNotesAndRecommendations()).isEqualTo("Some Notes And Recommendations 03");
    }

    @Test
    @Order(4)
    void findPractitionerNotesById() {
        // When
        Note note = practitionerRepository.findPractitionerNotesById(secondNote.getId());

        // Then
        assertThat(note.getPatientId()).isEqualTo(2);
        assertThat(note.getNotesAndRecommendations()).isEqualTo("Some Notes 02");
    }
}
