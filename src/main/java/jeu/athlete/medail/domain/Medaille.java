package jeu.athlete.medail.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

/**
 * Représente une médaille attribuée à un athlète lors d'une compétition.
 */
@Entity
@Table(name = "medaille")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medaille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeMedaille type; // OR, ARGENT, BRONZE

    private LocalDate dateObtention;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays_id", nullable = false)
    private Pays pays;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;
}
