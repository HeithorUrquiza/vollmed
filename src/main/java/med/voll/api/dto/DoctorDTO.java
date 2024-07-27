package med.voll.api.dto;

public record DoctorDTO(
        String name,
        String email,
        String cellphone,
        String crm,
        SpeciallityDTO speciality,
        PersonalAddressDTO personalAddress
) {}
