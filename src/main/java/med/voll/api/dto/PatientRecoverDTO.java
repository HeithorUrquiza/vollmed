package med.voll.api.dto;

import med.voll.api.models.Patient;

public record PatientRecoverDTO(
        String name,
        String email,
        String cpf
) {
    public PatientRecoverDTO(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
