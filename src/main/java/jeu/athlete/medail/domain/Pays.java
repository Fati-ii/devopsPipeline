package jeu.athlete.medail.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * Représente une nation ou délégation olympique.
 */
@Entity
@Table(name = "pays")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String nom;

    private String drapeau;

    @OneToMany(mappedBy = "pays", cascade = CascadeType.ALL)
    private List<Athlete> athletes;

    @OneToMany(mappedBy = "pays", cascade = CascadeType.ALL)
    private List<Medaille> medailles;
}
