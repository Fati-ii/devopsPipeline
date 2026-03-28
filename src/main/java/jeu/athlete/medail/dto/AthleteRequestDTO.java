package jeu.athlete.medail.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

/**
 * DTO pour la création ou mise à jour d'un athlète.
 */
@Data
public class AthleteRequestDTO {
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    
    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;
    
    private LocalDate dateNaissance;
    
    @NotBlank(message = "La discipline est obligatoire")
    private String discipline;
    
    @NotNull(message = "Le pays est obligatoire")
    private Long paysId;
}
