package med.voll.api.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.dto.SpeciallityDTO;

@Entity
@Table(name = "doctors")
// Generate all getters methods
@Getter
// Generate all setters methods
@Setter
// Generate default constructor
@NoArgsConstructor
// Objects became equals by id
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cellphone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private SpeciallityDTO speciality;
    @Embedded
    private PersonalAddress personalAddress;

    public Doctor(DoctorDTO doctorDTO) {
        this.name = doctorDTO.name();
        this.email = doctorDTO.email();
        this.cellphone = doctorDTO.cellphone();
        this.crm = doctorDTO.crm();
        this.speciality = doctorDTO.speciality();
        this.personalAddress = new PersonalAddress(doctorDTO.personalAddress());
    }
}
