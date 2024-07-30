package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.DoctorRecoverDTO;
import med.voll.api.dto.DoctorRegistryDTO;
import med.voll.api.dto.DoctorUpdateDTO;
import med.voll.api.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @Transactional
    public String registryDoctor(@RequestBody @Valid DoctorRegistryDTO doctorRegistryDTO) {
        this.doctorService.registryDoctor(doctorRegistryDTO);
        return "Doctor saved";
    }

    @GetMapping
    public Page<DoctorRecoverDTO> getAllDoctors(Pageable pagination) {
        return this.doctorService.getAllDoctors(pagination);
    }

    @PutMapping
    @Transactional
    public String updateDoctor(@RequestBody @Valid DoctorUpdateDTO doctorUpdateDTO) {
        this.doctorService.updateDoctor(doctorUpdateDTO);
        return "Doctor updated";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deleteDoctor(@PathVariable Long id) {
        this.doctorService.deleteDoctor(id);
        return "Doctor deleted";
    }
}
