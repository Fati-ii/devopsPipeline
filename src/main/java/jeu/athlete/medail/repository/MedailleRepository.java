package jeu.athlete.medail.repository;

import jeu.athlete.medail.domain.Medaille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Interface pour la gestion de la persistance des médailles.
 */
@Repository
public interface MedailleRepository extends JpaRepository<Medaille, Long> {
    List<Medaille> findByAthleteId(Long athleteId);
    List<Medaille> findByCompetitionId(Long competitionId);
}
