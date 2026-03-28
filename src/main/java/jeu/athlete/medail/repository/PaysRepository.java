package jeu.athlete.medail.repository;

import jeu.athlete.medail.domain.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface pour la gestion de la persistance des pays.
 */
@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {
}
