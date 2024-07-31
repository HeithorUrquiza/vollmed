package med.voll.api.services;

import med.voll.api.dto.doctor.DoctorRecoverDTO;
import med.voll.api.dto.doctor.DoctorRegistryDTO;
import med.voll.api.dto.doctor.DoctorUpdateDTO;
import med.voll.api.models.Doctor;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public Doctor registryDoctor(DoctorRegistryDTO doctorRegistryDTO) {
        Doctor newDoctor = new Doctor(doctorRegistryDTO);
        this.doctorRepository.save(newDoctor);
        return newDoctor;
    }

//  Don't need @Transactional because it's read only
    public Doctor getDoctor(Long id) {
        return this.doctorRepository.getReferenceById(id);
    }

//  This method controlls the pagination (type, quantity and number)
    public Page<DoctorRecoverDTO> getAllDoctors(@PageableDefault(size=10, sort = {"name", "desc"}) Pageable pagination) {
        return this.doctorRepository.findAllByActiveTrue(pagination).map(DoctorRecoverDTO::new);
    }

    @Transactional
    public Doctor updateDoctor(DoctorUpdateDTO doctorUpdateDTO) {
        Doctor doctorDB = this.doctorRepository.getReferenceById(doctorUpdateDTO.id());
        doctorDB.updateInfos(doctorUpdateDTO);
        return doctorDB;
    }

    @Transactional
    public void deleteDoctor(Long id) {
        Doctor doctorDB = this.doctorRepository.getReferenceById(id);
        doctorDB.setActive(false);
    }
}
