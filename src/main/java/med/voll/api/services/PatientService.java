package med.voll.api.services;

import med.voll.api.dto.PatientDTO;
import med.voll.api.models.Patient;
import med.voll.api.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public void registryPatient(PatientDTO patientDTO) {
        this.patientRepository.save(new Patient(patientDTO));
    }
}
