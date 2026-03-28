package jeu.athlete.medail.dto;

import lombok.Data;
import java.time.LocalDate;

/**
 * DTO pour le renvoi des informations d'un athlète.
 */
@Data
public class AthleteResponseDTO {
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String discipline;
    private PaysResponseDTO pays;
}
