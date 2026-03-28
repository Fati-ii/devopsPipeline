package jeu.athlete.medail.service;

import jeu.athlete.medail.domain.Competition;
import jeu.athlete.medail.dto.CompetitionRequestDTO;
import jeu.athlete.medail.dto.CompetitionResponseDTO;
import jeu.athlete.medail.exception.ResourceNotFoundException;
import jeu.athlete.medail.repository.CompetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service gérant la planification et le suivi des compétitions.
 */
@Service
@RequiredArgsConstructor
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    public CompetitionResponseDTO create(CompetitionRequestDTO dto) {
        Competition comp = Competition.builder()
                .nom(dto.getNom())
                .discipline(dto.getDiscipline())
                .dateDebut(dto.getDateDebut())
                .dateFin(dto.getDateFin())
                .statut(dto.getStatut())
                .build();
        return mapToDTO(competitionRepository.save(comp));
    }

    public CompetitionResponseDTO update(Long id, CompetitionRequestDTO dto) {
        Competition comp = competitionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compétition introuvable."));
        comp.setNom(dto.getNom());
        comp.setDiscipline(dto.getDiscipline());
        comp.setDateDebut(dto.getDateDebut());
        comp.setDateFin(dto.getDateFin());
        comp.setStatut(dto.getStatut());
        return mapToDTO(competitionRepository.save(comp));
    }

    public CompetitionResponseDTO findById(Long id) {
        return competitionRepository.findById(id).map(this::mapToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Compétition introuvable."));
    }

    public List<CompetitionResponseDTO> findAll() {
        return competitionRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public void delete(Long id) {
        competitionRepository.deleteById(id);
    }

    private CompetitionResponseDTO mapToDTO(Competition comp) {
        CompetitionResponseDTO dto = new CompetitionResponseDTO();
        dto.setId(comp.getId());
        dto.setNom(comp.getNom());
        dto.setDiscipline(comp.getDiscipline());
        dto.setDateDebut(comp.getDateDebut());
        dto.setDateFin(comp.getDateFin());
        dto.setStatut(comp.getStatut());
        return dto;
    }
}
