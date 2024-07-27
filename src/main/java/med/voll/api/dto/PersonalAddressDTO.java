package med.voll.api.dto;

public record PersonalAddressDTO(
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String uf,
        String cep
) {}
