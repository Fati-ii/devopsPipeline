package jeu.athlete.medail.service;

import jeu.athlete.medail.domain.Medaille;
import jeu.athlete.medail.domain.Pays;
import jeu.athlete.medail.domain.TypeMedaille;
import jeu.athlete.medail.dto.ClassementDTO;
import jeu.athlete.medail.exception.ResourceNotFoundException;
import jeu.athlete.medail.repository.PaysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Service responsable du calcul des classements et des statistiques des médailles.
 */
@Service
@RequiredArgsConstructor
public class ClassementService {

    private final PaysRepository paysRepository;

    public List<ClassementDTO> getClassement(String tri) {
        List<Pays> paysList = paysRepository.findAll();
        List<ClassementDTO> classement = new ArrayList<>();

        for (Pays p : paysList) {
            int or = 0, argent = 0, bronze = 0;
            if (p.getMedailles() != null) {
                for (Medaille m : p.getMedailles()) {
                    if (m.getType() == TypeMedaille.OR) or++;
                    else if (m.getType() == TypeMedaille.ARGENT) argent++;
                    else if (m.getType() == TypeMedaille.BRONZE) bronze++;
                }
            }
            int total = or + argent + bronze;
            int points = (or * 3) + (argent * 2) + bronze;

            classement.add(ClassementDTO.builder()
                    .paysId(p.getId())
                    .nomPays(p.getNom())
                    .codePays(p.getCode())
                    .orCount(or)
                    .argentCount(argent)
                    .bronzeCount(bronze)
                    .total(total)
                    .points(points)
                    .build());
        }

        if ("or".equalsIgnoreCase(tri)) {
            classement.sort(Comparator.comparingInt(ClassementDTO::getOrCount).reversed());
        } else if ("points".equalsIgnoreCase(tri)) {
            classement.sort(Comparator.comparingInt(ClassementDTO::getPoints).reversed());
        } else {
            classement.sort(Comparator.comparingInt(ClassementDTO::getTotal).reversed());
        }

        return classement;
    }

    public ClassementDTO getStatsPays(Long paysId) {
        Pays p = paysRepository.findById(paysId)
                .orElseThrow(() -> new ResourceNotFoundException("Pays introuvable avec l'ID: " + paysId));
        
        int or = 0, argent = 0, bronze = 0;
        if (p.getMedailles() != null) {
            for (Medaille m : p.getMedailles()) {
                if (m.getType() == TypeMedaille.OR) or++;
                else if (m.getType() == TypeMedaille.ARGENT) argent++;
                else if (m.getType() == TypeMedaille.BRONZE) bronze++;
            }
        }
        return ClassementDTO.builder()
                .paysId(p.getId())
                .nomPays(p.getNom())
                .codePays(p.getCode())
                .orCount(or)
                .argentCount(argent)
                .bronzeCount(bronze)
                .total(or + argent + bronze)
                .points((or * 3) + (argent * 2) + bronze)
                .build();
    }
}
