package jeu.athlete.medail.dto;

import lombok.Data;

@Data
public class PaysResponseDTO {
    private Long id;
    private String code;
    private String nom;
    private String drapeau;
}
