package med.voll.api.services;

import med.voll.api.dto.DoctorDTO;
import med.voll.api.models.Doctor;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public void registryDoctor(DoctorDTO doctorDTO) {
        this.doctorRepository.save(new Doctor(doctorDTO));
    }
}
