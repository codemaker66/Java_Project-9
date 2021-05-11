package com.footforwarddevelopmentconsultancy.practitionermicroservice.service;

import com.footforwarddevelopmentconsultancy.practitionermicroservice.repository.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruncateService {

    @Autowired
    PractitionerRepository practitionerRepository;

    public void truncateNotesTable() {
        practitionerRepository.deleteAll();
    }
}
