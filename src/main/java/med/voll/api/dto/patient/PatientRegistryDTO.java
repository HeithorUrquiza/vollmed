package med.voll.api.dto.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.dto.PersonalAddressDTO;

public record PatientRegistryDTO(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String cellphone,
        @NotBlank @Pattern(regexp = "\\d{11}") String cpf,
        @NotNull @Valid PersonalAddressDTO personalAddress
) {}
