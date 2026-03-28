package jeu.athlete.medail.service;

import jeu.athlete.medail.domain.Athlete;
import jeu.athlete.medail.domain.Pays;
import jeu.athlete.medail.dto.AthleteRequestDTO;
import jeu.athlete.medail.dto.AthleteResponseDTO;
import jeu.athlete.medail.exception.ResourceNotFoundException;
import jeu.athlete.medail.repository.AthleteRepository;
import jeu.athlete.medail.repository.PaysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service gérant la logique métier relative aux athlètes.
 */
@Service
@RequiredArgsConstructor
public class AthleteService {

    private final AthleteRepository athleteRepository;
    private final PaysRepository paysRepository;
    private final PaysService paysService;

    public AthleteResponseDTO create(AthleteRequestDTO dto) {
        Pays pays = paysRepository.findById(dto.getPaysId())
                .orElseThrow(() -> new ResourceNotFoundException("Pays introuvable avec l'ID: " + dto.getPaysId()));
        
        Athlete athlete = Athlete.builder()
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .dateNaissance(dto.getDateNaissance())
                .discipline(dto.getDiscipline())
                .pays(pays)
                .build();
        
        return mapToDTO(athleteRepository.save(athlete));
    }

    public AthleteResponseDTO update(Long id, AthleteRequestDTO dto) {
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Athlète introuvable avec l'ID: " + id));
        
        Pays pays = paysRepository.findById(dto.getPaysId())
                .orElseThrow(() -> new ResourceNotFoundException("Pays introuvable avec l'ID: " + dto.getPaysId()));

        athlete.setNom(dto.getNom());
        athlete.setPrenom(dto.getPrenom());
        athlete.setDateNaissance(dto.getDateNaissance());
        athlete.setDiscipline(dto.getDiscipline());
        athlete.setPays(pays);
        
        return mapToDTO(athleteRepository.save(athlete));
    }

    public AthleteResponseDTO findById(Long id) {
        return athleteRepository.findById(id).map(this::mapToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Athlète introuvable."));
    }

    public Page<AthleteResponseDTO> findAll(Pageable pageable) {
        return athleteRepository.findAll(pageable).map(this::mapToDTO);
    }

    public List<AthleteResponseDTO> findByPaysId(Long paysId) {
        return athleteRepository.findByPaysId(paysId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public void delete(Long id) {
        athleteRepository.deleteById(id);
    }

    public AthleteResponseDTO mapToDTO(Athlete athlete) {
        AthleteResponseDTO dto = new AthleteResponseDTO();
        dto.setId(athlete.getId());
        dto.setNom(athlete.getNom());
        dto.setPrenom(athlete.getPrenom());
        dto.setDateNaissance(athlete.getDateNaissance());
        dto.setDiscipline(athlete.getDiscipline());
        if (athlete.getPays() != null) {
            dto.setPays(paysService.mapToDTO(athlete.getPays()));
        }
        return dto;
    }
}
