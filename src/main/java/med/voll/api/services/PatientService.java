package med.voll.api.services;

import med.voll.api.dto.DoctorRecoverDTO;
import med.voll.api.dto.PatientRecoverDTO;
import med.voll.api.dto.PatientRegistryDTO;
import med.voll.api.dto.PatientUpdateDTO;
import med.voll.api.models.Patient;
import med.voll.api.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public void registryPatient(PatientRegistryDTO patientRegistryDTO) {
        this.patientRepository.save(new Patient(patientRegistryDTO));
    }

    public Page<PatientRecoverDTO> getAllPatients(@PageableDefault(size=10, sort = {"name", "desc"}) Pageable pagination) {
        return this.patientRepository.findAllByActiveTrue(pagination).map(PatientRecoverDTO::new);
    }

    public void updatePatient(PatientUpdateDTO patientUpdateDTO) {
        Patient patientDB = this.patientRepository.getReferenceById(patientUpdateDTO.id());
        patientDB.updateInfos(patientUpdateDTO);
    }

    public void deletePatient(Long id) {
        Patient patientDB = this.patientRepository.getReferenceById(id);
        patientDB.setActive(false);
    }
}
