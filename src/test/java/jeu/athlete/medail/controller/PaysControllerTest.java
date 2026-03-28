package jeu.athlete.medail.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PaysControllerTest {

    @Autowired
    private PaysController paysController;

    @Test
    void contextLoads() {
        // Test d'intégration qui vérifie le bon chargement du contexte Spring et l'injection du contrôleur
        assertNotNull(paysController);
    }
}
