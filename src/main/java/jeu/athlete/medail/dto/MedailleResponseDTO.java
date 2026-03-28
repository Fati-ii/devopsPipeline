package jeu.athlete.medail.dto;

import jeu.athlete.medail.domain.TypeMedaille;
import lombok.Data;
import java.time.LocalDate;

/**
 * DTO pour le renvoi des détails d'une médaille.
 */
@Data
public class MedailleResponseDTO {
    private Long id;
    private TypeMedaille type;
    private LocalDate dateObtention;
    private Long athleteId;
    private String nomAthlete;
    private Long paysId;
    private String nomPays;
    private Long competitionId;
    private String nomCompetition;
}
