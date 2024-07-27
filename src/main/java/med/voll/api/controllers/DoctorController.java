package med.voll.api.controllers;

import med.voll.api.dto.DoctorDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @PostMapping
    public void registryDoctor(@RequestBody DoctorDTO doctorDTO) {
        System.out.println(doctorDTO);
    }
}
