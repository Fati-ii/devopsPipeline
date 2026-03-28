package jeu.athlete.medail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO représentant une ligne du tableau des médailles.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassementDTO {
    private Long paysId;
    private String nomPays;
    private String codePays;
    private int orCount;
    private int argentCount;
    private int bronzeCount;
    private int total;
    private int points; // (Or=3, Argent=2, Bronze=1)
}
