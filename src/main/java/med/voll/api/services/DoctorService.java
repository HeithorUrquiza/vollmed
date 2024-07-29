package med.voll.api.services;

import med.voll.api.dto.DoctorRecoverDTO;
import med.voll.api.dto.DoctorRegistryDTO;
import med.voll.api.models.Doctor;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public void registryDoctor(DoctorRegistryDTO doctorRegistryDTO) {
        this.doctorRepository.save(new Doctor(doctorRegistryDTO));
    }

//    This method controlls the pagination (type, quantity and number)
    public Page<DoctorRecoverDTO> getAllDoctors(@PageableDefault(size=10, sort = {"name", "desc"}) Pageable pagination) {
        return this.doctorRepository.findAll(pagination).map(DoctorRecoverDTO::new);
    }
}
