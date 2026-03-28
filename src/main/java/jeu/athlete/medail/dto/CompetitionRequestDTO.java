package jeu.athlete.medail.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;

/**
 * DTO pour la création ou mise à jour d'une compétition.
 */
@Data
public class CompetitionRequestDTO {
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    
    private String discipline;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String statut;
}
