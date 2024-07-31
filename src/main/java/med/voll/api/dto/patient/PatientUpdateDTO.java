package med.voll.api.dto.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.PersonalAddressDTO;

public record PatientUpdateDTO(
        @NotNull Long id,
        String name,
        String cellphone,
        PersonalAddressDTO personalAddress
) {}

