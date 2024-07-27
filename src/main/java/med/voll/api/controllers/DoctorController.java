package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public String registryDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        this.doctorService.registryDoctor(doctorDTO);
        return "Doctor saved";
    }
}
