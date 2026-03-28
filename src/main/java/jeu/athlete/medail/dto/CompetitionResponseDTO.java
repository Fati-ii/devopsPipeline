package jeu.athlete.medail.dto;

import lombok.Data;
import java.time.LocalDate;

/**
 * DTO pour le renvoi des informations d'une compétition.
 */
@Data
public class CompetitionResponseDTO {
    private Long id;
    private String nom;
    private String discipline;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String statut;
}
