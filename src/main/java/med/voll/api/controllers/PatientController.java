package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.patient.PatientDetailDTO;
import med.voll.api.dto.patient.PatientRecoverDTO;
import med.voll.api.dto.patient.PatientRegistryDTO;
import med.voll.api.dto.patient.PatientUpdateDTO;
import med.voll.api.models.Patient;
import med.voll.api.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDetailDTO> registryPatient(@RequestBody @Valid PatientRegistryDTO patientRegistryDTO,
                                                            UriComponentsBuilder uriBuilder) {
        Patient newPatient = this.patientService.registryPatient(patientRegistryDTO);
        URI uri = uriBuilder.path("/patients/{id}").buildAndExpand(newPatient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PatientDetailDTO(newPatient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDetailDTO> getPatient(@PathVariable Long id) {
        Patient foundPatient = this.patientService.getPatient(id);
        return ResponseEntity.ok(new PatientDetailDTO(foundPatient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientRecoverDTO>> getAllPatients(Pageable pagination) {
        Page<PatientRecoverDTO> page = this.patientService.getAllPatients(pagination);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity<PatientDetailDTO> updatePatient(@RequestBody @Valid PatientUpdateDTO patientUpdateDTO) {
        Patient updatedPatient = this.patientService.updatePatient(patientUpdateDTO);
        return ResponseEntity.ok(new PatientDetailDTO(updatedPatient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        this.patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
