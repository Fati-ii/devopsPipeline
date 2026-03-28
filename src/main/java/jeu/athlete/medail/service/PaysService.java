package jeu.athlete.medail.service;

import jeu.athlete.medail.domain.Pays;
import jeu.athlete.medail.dto.PaysRequestDTO;
import jeu.athlete.medail.dto.PaysResponseDTO;
import jeu.athlete.medail.exception.ResourceNotFoundException;
import jeu.athlete.medail.repository.PaysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service gérant les informations relatives aux pays et délégations.
 */
@Service
@RequiredArgsConstructor
public class PaysService {

    private final PaysRepository paysRepository;

    public PaysResponseDTO create(PaysRequestDTO dto) {
        Pays pays = Pays.builder()
                .code(dto.getCode())
                .nom(dto.getNom())
                .drapeau(dto.getDrapeau())
                .build();
        return mapToDTO(paysRepository.save(pays));
    }

    public PaysResponseDTO update(Long id, PaysRequestDTO dto) {
        Pays pays = paysRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pays introuvable avec l'ID: " + id));
        pays.setCode(dto.getCode());
        pays.setNom(dto.getNom());
        pays.setDrapeau(dto.getDrapeau());
        return mapToDTO(paysRepository.save(pays));
    }

    public PaysResponseDTO findById(Long id) {
        return paysRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Pays introuvable avec l'ID: " + id));
    }

    public List<PaysResponseDTO> findAll() {
        return paysRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!paysRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pays introuvable avec l'ID: " + id);
        }
        paysRepository.deleteById(id);
    }

    public PaysResponseDTO mapToDTO(Pays pays) {
        PaysResponseDTO dto = new PaysResponseDTO();
        dto.setId(pays.getId());
        dto.setCode(pays.getCode());
        dto.setNom(pays.getNom());
        dto.setDrapeau(pays.getDrapeau());
        return dto;
    }
}
