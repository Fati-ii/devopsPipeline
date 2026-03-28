package jeu.athlete.medail.controller;

import jeu.athlete.medail.dto.PaysRequestDTO;
import jeu.athlete.medail.dto.PaysResponseDTO;
import jeu.athlete.medail.service.PaysService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des pays et délégations.
 */
@RestController
@RequestMapping("/api/v1/pays")
@RequiredArgsConstructor
public class PaysController {

    private final PaysService paysService;

    @GetMapping
    public List<PaysResponseDTO> getAllPays() {
        return paysService.findAll();
    }

    @GetMapping("/{id}")
    public PaysResponseDTO getPaysById(@PathVariable Long id) {
        return paysService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaysResponseDTO createPays(@Valid @RequestBody PaysRequestDTO dto) {
        return paysService.create(dto);
    }

    @PutMapping("/{id}")
    public PaysResponseDTO updatePays(@PathVariable Long id, @Valid @RequestBody PaysRequestDTO dto) {
        return paysService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePays(@PathVariable Long id) {
        paysService.delete(id);
    }
}
