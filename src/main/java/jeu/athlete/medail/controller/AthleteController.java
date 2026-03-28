package jeu.athlete.medail.controller;

import jeu.athlete.medail.dto.AthleteRequestDTO;
import jeu.athlete.medail.dto.AthleteResponseDTO;
import jeu.athlete.medail.service.AthleteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import java.util.List;

/**
 * Contrôleur REST pour la gestion des athlètes.
 */
@RestController
@RequestMapping("/api/v1/athletes")
@RequiredArgsConstructor
public class AthleteController {

    private final AthleteService athleteService;

    @GetMapping
    public Page<AthleteResponseDTO> getAllAthletes(@PageableDefault(size = 20) Pageable pageable) {
        return athleteService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public AthleteResponseDTO getAthleteById(@PathVariable Long id) {
        return athleteService.findById(id);
    }

    @GetMapping("/pays/{paysId}")
    public List<AthleteResponseDTO> getAthletesByPays(@PathVariable Long paysId) {
        return athleteService.findByPaysId(paysId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AthleteResponseDTO createAthlete(@Valid @RequestBody AthleteRequestDTO dto) {
        return athleteService.create(dto);
    }

    @PutMapping("/{id}")
    public AthleteResponseDTO updateAthlete(@PathVariable Long id, @Valid @RequestBody AthleteRequestDTO dto) {
        return athleteService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAthlete(@PathVariable Long id) {
        athleteService.delete(id);
    }
}
