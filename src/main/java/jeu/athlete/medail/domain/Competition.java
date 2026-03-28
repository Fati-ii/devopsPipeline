package jeu.athlete.medail.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Représente une épreuve ou compétition sportive.
 */
@Entity
@Table(name = "competition")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    private String discipline;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    private String statut;

    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL)
    private List<Medaille> medailles;
}
