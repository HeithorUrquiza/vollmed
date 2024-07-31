package med.voll.api.dto.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.PersonalAddressDTO;

public record DoctorUpdateDTO(
        @NotNull Long id,
        String name,
        String cellphone,
        PersonalAddressDTO personalAddress
) {}
