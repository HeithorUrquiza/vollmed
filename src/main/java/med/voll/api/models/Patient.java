package med.voll.api.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.PatientDTO;

@Entity
@Table(name= "patients")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cellphone;
    private String cpf;
    @Embedded
    private PersonalAddress personalAddress;

    public Patient(PatientDTO patientDTO) {
        this.name = patientDTO.name();
        this.email = patientDTO.email();
        this.cellphone = patientDTO.cellphone();
        this.cpf = patientDTO.cpf();
        this.personalAddress = new PersonalAddress(patientDTO.personalAddress());
    }
}
