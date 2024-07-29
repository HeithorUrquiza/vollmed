package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.DoctorRecoverDTO;
import med.voll.api.dto.DoctorRegistryDTO;
import med.voll.api.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public String registryDoctor(@RequestBody @Valid DoctorRegistryDTO doctorRegistryDTO) {
        this.doctorService.registryDoctor(doctorRegistryDTO);
        return "Doctor saved";
    }

    @GetMapping
    public Page<DoctorRecoverDTO> getAllDoctors(Pageable pagination) {
        return this.doctorService.getAllDoctors(pagination);
    }
}
