package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.PatientDTO;
import med.voll.api.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public String registryPatient(@RequestBody @Valid PatientDTO patientDTO) {
        this.patientService.registryPatient(patientDTO);
        return "Patient saved";
    }
}
