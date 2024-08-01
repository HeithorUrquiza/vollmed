package med.voll.api.dto;

import jakarta.validation.constraints.NotBlank;

public record UserAccessDTO(
        @NotBlank String login,
        @NotBlank String password
) {}
