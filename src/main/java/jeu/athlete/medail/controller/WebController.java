package jeu.athlete.medail.controller;

import jeu.athlete.medail.service.ClassementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Contrôleur gérant l'affichage des pages Web (Thymeleaf).
 */
@Controller
@RequiredArgsConstructor
public class WebController {

    private final ClassementService classementService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/tableau-medailles")
    public String classement(Model model) {
        model.addAttribute("classement", classementService.getClassement("total"));
        return "classement";
    }
}
