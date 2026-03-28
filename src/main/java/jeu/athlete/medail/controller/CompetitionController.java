package jeu.athlete.medail.controller;

import jeu.athlete.medail.dto.CompetitionRequestDTO;
import jeu.athlete.medail.dto.CompetitionResponseDTO;
import jeu.athlete.medail.service.CompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des compétitions.
 */
@RestController
@RequestMapping("/api/v1/competitions")
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;

    @GetMapping
    public List<CompetitionResponseDTO> getAllCompetitions() {
        return competitionService.findAll();
    }

    @GetMapping("/{id}")
    public CompetitionResponseDTO getCompetitionById(@PathVariable Long id) {
        return competitionService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompetitionResponseDTO createCompetition(@Valid @RequestBody CompetitionRequestDTO dto) {
        return competitionService.create(dto);
    }

    @PutMapping("/{id}")
    public CompetitionResponseDTO updateCompetition(@PathVariable Long id, @Valid @RequestBody CompetitionRequestDTO dto) {
        return competitionService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompetition(@PathVariable Long id) {
        competitionService.delete(id);
    }
}
