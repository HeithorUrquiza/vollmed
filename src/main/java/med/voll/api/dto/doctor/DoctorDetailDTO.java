package med.voll.api.dto.doctor;

import med.voll.api.dto.SpeciallityDTO;
import med.voll.api.models.Doctor;
import med.voll.api.models.PersonalAddress;

public record DoctorDetailDTO(
        Long id,
        String name,
        String email,
        String crm,
        String cellphone,
        SpeciallityDTO speciality,
        PersonalAddress personalAddress
) {
    public DoctorDetailDTO(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getCellphone(),
                doctor.getSpeciality(), doctor.getPersonalAddress());
    }
}
