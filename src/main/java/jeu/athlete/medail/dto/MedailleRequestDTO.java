package jeu.athlete.medail.dto;

import jeu.athlete.medail.domain.TypeMedaille;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

/**
 * DTO pour l'enregistrement d'une nouvelle médaille.
 */
@Data
public class MedailleRequestDTO {
    @NotNull(message = "Le type de médaille est obligatoire")
    private TypeMedaille type; // OR, ARGENT, BRONZE
    
    private LocalDate dateObtention;
    
    @NotNull(message = "L'athlète est obligatoire")
    private Long athleteId;
    
    @NotNull(message = "La compétition est obligatoire")
    private Long competitionId;
}
