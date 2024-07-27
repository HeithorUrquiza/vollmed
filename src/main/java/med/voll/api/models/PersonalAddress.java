package med.voll.api.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.PersonalAddressDTO;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class PersonalAddress {
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String uf;
    private String cep;

    public PersonalAddress(PersonalAddressDTO personalAddressDTO) {
        this.street = personalAddressDTO.street();
        this.number = personalAddressDTO.number();
        this.complement = personalAddressDTO.complement();
        this.neighborhood = personalAddressDTO.neighborhood();
        this.city = personalAddressDTO.city();
        this.uf = personalAddressDTO.uf();
        this.cep = personalAddressDTO.cep();
    }
}
