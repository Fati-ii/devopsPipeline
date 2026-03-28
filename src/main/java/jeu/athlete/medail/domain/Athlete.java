package jeu.athlete.medail.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Représente un athlète participant aux Jeux Olympiques.
 */
@Entity
@Table(name = "athlete")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private LocalDate dateNaissance;

    private String discipline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays_id", nullable = false)
    private Pays pays;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<Medaille> medailles;
}
