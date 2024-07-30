package med.voll.api.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.DoctorRegistryDTO;
import med.voll.api.dto.DoctorUpdateDTO;
import med.voll.api.dto.SpeciallityDTO;

import java.util.Optional;

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
    private Boolean active;

    public Doctor(DoctorRegistryDTO doctorRegistryDTO) {
        this.name = doctorRegistryDTO.name();
        this.email = doctorRegistryDTO.email();
        this.cellphone = doctorRegistryDTO.cellphone();
        this.crm = doctorRegistryDTO.crm();
        this.speciality = doctorRegistryDTO.speciality();
        this.personalAddress = new PersonalAddress(doctorRegistryDTO.personalAddress());
    }

    public void updateInfos(DoctorUpdateDTO doctorUpdateDTO) {
        Optional.ofNullable(doctorUpdateDTO.name()).ifPresent(this::setName);
        Optional.ofNullable(doctorUpdateDTO.cellphone()).ifPresent(this::setCellphone);
        Optional.ofNullable(doctorUpdateDTO.personalAddress()).ifPresent(personalAddress ->
                this.personalAddress.updateInfos(personalAddress));
    }
}
