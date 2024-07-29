package med.voll.api.dto;

import med.voll.api.models.Doctor;

public record DoctorRecoverDTO(
        String name,
        String email,
        String crm,
        SpeciallityDTO speciality
) {
    public DoctorRecoverDTO(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality());
    }
}

