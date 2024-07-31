package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.patient.PatientRecoverDTO;
import med.voll.api.dto.patient.PatientRegistryDTO;
import med.voll.api.dto.patient.PatientUpdateDTO;
import med.voll.api.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    @Transactional
    public String registryPatient(@RequestBody @Valid PatientRegistryDTO patientRegistryDTO) {
        this.patientService.registryPatient(patientRegistryDTO);
        return "Patient saved";
    }

    @GetMapping
    public Page<PatientRecoverDTO> getAllPatients(Pageable pagination) {
        return this.patientService.getAllPatients(pagination);
    }

    @PutMapping
    @Transactional
    public String updatePatient(@RequestBody @Valid PatientUpdateDTO patientUpdateDTO) {
        this.patientService.updatePatient(patientUpdateDTO);
        return "Patient updated";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deletePatient(@PathVariable Long id) {
        this.patientService.deletePatient(id);
        return "Patient deleted";
    }
}
