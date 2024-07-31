package med.voll.api.services;

import med.voll.api.dto.patient.PatientRecoverDTO;
import med.voll.api.dto.patient.PatientRegistryDTO;
import med.voll.api.dto.patient.PatientUpdateDTO;
import med.voll.api.models.Patient;
import med.voll.api.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public Patient registryPatient(PatientRegistryDTO patientRegistryDTO) {
        Patient newPatient = new Patient(patientRegistryDTO);
        this.patientRepository.save(newPatient);
        return newPatient;
    }

    public Patient getPatient(Long id) {
        return this.patientRepository.getReferenceById(id);
    }

    public Page<PatientRecoverDTO> getAllPatients(@PageableDefault(size=10, sort = {"name", "desc"}) Pageable pagination) {
        return this.patientRepository.findAllByActiveTrue(pagination).map(PatientRecoverDTO::new);
    }

    @Transactional
    public Patient updatePatient(PatientUpdateDTO patientUpdateDTO) {
        Patient patientDB = this.patientRepository.getReferenceById(patientUpdateDTO.id());
        patientDB.updateInfos(patientUpdateDTO);
        return patientDB;
    }

    @Transactional
    public void deletePatient(Long id) {
        Patient patientDB = this.patientRepository.getReferenceById(id);
        patientDB.setActive(false);
    }
}
