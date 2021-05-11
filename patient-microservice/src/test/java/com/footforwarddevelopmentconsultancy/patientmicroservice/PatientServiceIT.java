package com.footforwarddevelopmentconsultancy.patientmicroservice;

import com.footforwarddevelopmentconsultancy.patientmicroservice.entity.Patient;
import com.footforwarddevelopmentconsultancy.patientmicroservice.repository.PatientRepository;
import com.footforwarddevelopmentconsultancy.patientmicroservice.service.TruncateService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PatientServiceIT {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    private TruncateService truncateService;

    private Patient firstPatient = new Patient();
    private Patient secondPatient = new Patient();

    @BeforeAll
    void init() {
        firstPatient.setName("Test Patient 01");
        firstPatient.setFamilyName("Test Patient 01 Family Name");
        LocalDate localDate = LocalDate.of(1970, 5, 12);
        firstPatient.setDateOfBirth(localDate);
        firstPatient.setGender("male");
        firstPatient.setPostalAddress("postal address 01");
        firstPatient.setPhoneNumber("0123456789");

        secondPatient.setName("Test Patient 02");
        secondPatient.setFamilyName("Test Patient 02 Family Name");
        localDate = LocalDate.of(1980, 10, 9);
        secondPatient.setDateOfBirth(localDate);
        secondPatient.setGender("female");
        secondPatient.setPostalAddress("postal address 02");
        secondPatient.setPhoneNumber("9876543210");
    }

    @AfterAll
    void clearTable() {
        truncateService.truncatePatientsTable();
    }

    @Test
    @Order(1)
    void registerThePatient() {
        // When
        firstPatient = patientRepository.save(firstPatient);
        secondPatient = patientRepository.save(secondPatient);

        // Then
        assertThat(firstPatient.getId()).isNotNull();
        assertThat(firstPatient.getPostalAddress()).isEqualTo("postal address 01");
        assertThat(secondPatient.getId()).isNotNull();
        assertThat(secondPatient.getPostalAddress()).isEqualTo("postal address 02");
    }

    @Test
    @Order(2)
    void updatePatientData() {
        // Given
        LocalDate localDate = LocalDate.of(1970, 07, 12);

        // When
        firstPatient.setDateOfBirth(localDate);
        firstPatient = patientRepository.save(firstPatient);
        secondPatient.setPostalAddress("postal address 22");
        secondPatient = patientRepository.save(secondPatient);

        // Then
        assertThat(firstPatient.getDateOfBirth()).isEqualTo(localDate);
        assertThat(secondPatient.getPostalAddress()).isEqualTo("postal address 22");
    }

    @Test
    @Order(3)
    void findAllPatients() {
        // When
        List<Patient> patients = patientRepository.retrieveAllPatients();

        // Then
        assertThat(patients.size()).isEqualTo(2);
    }

    @Test
    @Order(4)
    void findPatientById() {
        // When
        Patient patient = patientRepository.findById(1);

        // Then
        assertThat(patient.getName()).isEqualTo("Test Patient 01");
    }

    @Test
    @Order(5)
    void findPatientByFamilyName() {
        // When
        Patient patient = patientRepository.findByFamilyName("Test Patient 02 Family Name");

        // Then
        assertThat(patient.getPhoneNumber()).isEqualTo("9876543210");
    }
}
