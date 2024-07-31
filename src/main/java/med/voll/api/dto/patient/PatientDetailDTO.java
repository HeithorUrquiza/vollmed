package med.voll.api.dto.patient;

import med.voll.api.models.Patient;
import med.voll.api.models.PersonalAddress;

public record PatientDetailDTO(
        Long id,
        String name,
        String email,
        String cellphone,
        String cpf,
        PersonalAddress personalAddress
) {
    public PatientDetailDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCellphone(), patient.getCpf(),
                patient.getPersonalAddress());
    }
}
