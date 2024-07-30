package med.voll.api.dto;

import med.voll.api.models.Patient;

public record PatientRecoverDTO(
        Long id,
        String name,
        String email,
        String cpf
) {
    public PatientRecoverDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
