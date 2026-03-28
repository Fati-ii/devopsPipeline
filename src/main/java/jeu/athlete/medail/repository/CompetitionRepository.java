package jeu.athlete.medail.repository;

import jeu.athlete.medail.domain.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface pour la gestion de la persistance des compétitions.
 */
@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
