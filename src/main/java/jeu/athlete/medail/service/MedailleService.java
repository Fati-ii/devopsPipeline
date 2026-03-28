package jeu.athlete.medail.service;

import jeu.athlete.medail.domain.Athlete;
import jeu.athlete.medail.domain.Competition;
import jeu.athlete.medail.domain.Medaille;
import jeu.athlete.medail.dto.MedailleRequestDTO;
import jeu.athlete.medail.dto.MedailleResponseDTO;
import jeu.athlete.medail.exception.ResourceNotFoundException;
import jeu.athlete.medail.repository.AthleteRepository;
import jeu.athlete.medail.repository.CompetitionRepository;
import jeu.athlete.medail.repository.MedailleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service gérant l'attribution et l'historique des médailles.
 */
@Service
@RequiredArgsConstructor
public class MedailleService {

    private final MedailleRepository medailleRepository;
    private final AthleteRepository athleteRepository;
    private final CompetitionRepository competitionRepository;

    public MedailleResponseDTO creer(MedailleRequestDTO dto) {
        Athlete athlete = athleteRepository.findById(dto.getAthleteId())
                .orElseThrow(() -> new ResourceNotFoundException("Athlète introuvable."));
        Competition competition = competitionRepository.findById(dto.getCompetitionId())
                .orElseThrow(() -> new ResourceNotFoundException("Compétition introuvable."));

        Medaille medaille = new Medaille();
        medaille.setType(dto.getType());
        medaille.setDateObtention(dto.getDateObtention() != null ? dto.getDateObtention() : LocalDate.now());
        medaille.setAthlete(athlete);
        medaille.setPays(athlete.getPays());
        medaille.setCompetition(competition);

        return mapToDTO(medailleRepository.save(medaille));
    }

    public MedailleResponseDTO findById(Long id) {
        return medailleRepository.findById(id).map(this::mapToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Médaille introuvable."));
    }

    public List<MedailleResponseDTO> findAll() {
        return medailleRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<MedailleResponseDTO> findByAthleteId(Long athleteId) {
        return medailleRepository.findByAthleteId(athleteId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<MedailleResponseDTO> findByCompetitionId(Long competitionId) {
        return medailleRepository.findByCompetitionId(competitionId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private MedailleResponseDTO mapToDTO(Medaille medaille) {
        MedailleResponseDTO dto = new MedailleResponseDTO();
        dto.setId(medaille.getId());
        dto.setType(medaille.getType());
        dto.setDateObtention(medaille.getDateObtention());
        
        if (medaille.getAthlete() != null) {
            dto.setAthleteId(medaille.getAthlete().getId());
            dto.setNomAthlete(medaille.getAthlete().getPrenom() + " " + medaille.getAthlete().getNom());
        }
        if (medaille.getPays() != null) {
            dto.setPaysId(medaille.getPays().getId());
            dto.setNomPays(medaille.getPays().getNom());
        }
        if (medaille.getCompetition() != null) {
            dto.setCompetitionId(medaille.getCompetition().getId());
            dto.setNomCompetition(medaille.getCompetition().getNom());
        }
        return dto;
    }
}
