package jeu.athlete.medail.controller;

import jeu.athlete.medail.dto.MedailleRequestDTO;
import jeu.athlete.medail.dto.MedailleResponseDTO;
import jeu.athlete.medail.service.MedailleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour l'attribution et la consultation des médailles.
 */
@RestController
@RequestMapping(value = {"/api/v1/medailles", "/api/v1/medalles"})
@RequiredArgsConstructor
public class MedailleController {

    private final MedailleService medailleService;

    @GetMapping
    public List<MedailleResponseDTO> getAllMedailles() {
        return medailleService.findAll();
    }

    @GetMapping("/{id}")
    public MedailleResponseDTO getMedailleById(@PathVariable Long id) {
        return medailleService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedailleResponseDTO createMedaille(@Valid @RequestBody MedailleRequestDTO dto) {
        return medailleService.creer(dto);
    }

    @GetMapping("/athlete/{athleteId}")
    public List<MedailleResponseDTO> getMedaillesByAthlete(@PathVariable Long athleteId) {
        return medailleService.findByAthleteId(athleteId);
    }

    @GetMapping("/competition/{competitionId}")
    public List<MedailleResponseDTO> getMedaillesByCompetition(@PathVariable Long competitionId) {
        return medailleService.findByCompetitionId(competitionId);
    }
}
