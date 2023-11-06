package com.esprit.examen.services;

import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceImplTest {
    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAddFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        fournisseur.setDetailFournisseur(detailFournisseur);

        // Configurez le comportement du mock pour les appels à fournisseurRepository.save()
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        // Configurez le comportement du mock pour les appels à detailFournisseurRepository.save()
        when(detailFournisseurRepository.save(detailFournisseur)).thenReturn(detailFournisseur);

        Fournisseur result = fournisseurService.addFournisseur(fournisseur);

        // Assurez-vous que la méthode a bien été appelée avec l'objet Fournisseur
        verify(fournisseurRepository).save(fournisseur);

        // Assurez-vous que la méthode a bien été appelée avec l'objet DetailFournisseur
       // verify(detailFournisseurRepository).save(detailFournisseur);

        assertNotNull(result);
        // Ajoutez d'autres assertions selon vos besoins pour vérifier le comportement attendu.
    }



}
