package jeu.athlete.medail.controller;

import jeu.athlete.medail.dto.ClassementDTO;
import jeu.athlete.medail.service.ClassementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la consultation des classements et statistiques.
 */
@RestController
@RequestMapping("/api/v1/classement")
@RequiredArgsConstructor
public class ClassementController {

    private final ClassementService classementService;

    @GetMapping
    public List<ClassementDTO> getClassement(
            @RequestParam(value = "tri", defaultValue = "total", required = false) String tri) {
        return classementService.getClassement(tri);
    }

    @GetMapping("/pays/{paysId}")
    public ClassementDTO getStatsByPays(@PathVariable Long paysId) {
        return classementService.getStatsPays(paysId);
    }
}
