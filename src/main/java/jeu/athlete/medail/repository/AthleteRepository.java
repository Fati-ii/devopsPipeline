package jeu.athlete.medail.repository;

import jeu.athlete.medail.domain.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Interface pour la gestion de la persistance des athlètes.
 */
@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    List<Athlete> findByPaysId(Long paysId);
}
