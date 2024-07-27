package med.voll.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SpeciallityDTO {
    ORTHOPEDIA("Ortopedia"),
    CARDIOLOGY("Cardiologia"),
    GYNECOLOGY("Ginecologia"),
    DERMATOLOGY("Dermatologia");

    private String speciality;

    SpeciallityDTO(String speciality) {
        this.speciality = speciality;
    }

    @JsonValue
    public String getSpeciality() {
        return speciality;
    }

    @JsonCreator
    public static SpeciallityDTO fromString(String speciality) {
        for (SpeciallityDTO s : SpeciallityDTO.values()) {
            if (s.getSpeciality().equalsIgnoreCase(speciality)) {
                return s;
            }
        }
        throw new IllegalArgumentException("No constant with text " + speciality + " found");
    }
}
