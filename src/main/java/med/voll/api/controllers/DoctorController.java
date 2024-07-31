package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.doctor.DoctorDetailDTO;
import med.voll.api.dto.doctor.DoctorRecoverDTO;
import med.voll.api.dto.doctor.DoctorRegistryDTO;
import med.voll.api.dto.doctor.DoctorUpdateDTO;
import med.voll.api.models.Doctor;
import med.voll.api.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorDetailDTO> registryDoctor(@RequestBody @Valid DoctorRegistryDTO doctorRegistryDTO,
                                                          UriComponentsBuilder uriBuilder) {
        Doctor newDoctor = this.doctorService.registryDoctor(doctorRegistryDTO);
        URI uri = uriBuilder.path("/doctors/{id}").buildAndExpand(newDoctor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DoctorDetailDTO(newDoctor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDetailDTO> getDoctor(@PathVariable Long id) {
        Doctor doctorFounded = this.doctorService.getDoctor(id);
        return ResponseEntity.ok(new DoctorDetailDTO(doctorFounded));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorRecoverDTO>> getAllDoctors(Pageable pagination) {
        Page<DoctorRecoverDTO> page = this.doctorService.getAllDoctors(pagination);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    public ResponseEntity<DoctorDetailDTO> updateDoctor(@RequestBody @Valid DoctorUpdateDTO doctorUpdateDTO) {
        Doctor updatedDoctor = this.doctorService.updateDoctor(doctorUpdateDTO);
        return ResponseEntity.ok(new DoctorDetailDTO(updatedDoctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        this.doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
