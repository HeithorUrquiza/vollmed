package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.PatientRecoverDTO;
import med.voll.api.dto.PatientRegistryDTO;
import med.voll.api.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public String registryPatient(@RequestBody @Valid PatientRegistryDTO patientRegistryDTO) {
        this.patientService.registryPatient(patientRegistryDTO);
        return "Patient saved";
    }

    @GetMapping
    public Page<PatientRecoverDTO> getAllPatients(Pageable pagination) {
        return this.patientService.getAllPatients(pagination);
    }
}
