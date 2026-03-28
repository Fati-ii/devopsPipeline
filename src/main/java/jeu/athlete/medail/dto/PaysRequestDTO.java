package jeu.athlete.medail.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PaysRequestDTO {
    @NotBlank(message = "Le code est obligatoire")
    private String code;
    
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    
    private String drapeau;
}
