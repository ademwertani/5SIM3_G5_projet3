package com.esprit.examen.controllers;

import com.esprit.examen.entities.Facture;
import org.testng.annotations.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

public class FactureTest {

    @Test
    public void testFactureConstruction() {
        Facture facture = new Facture();
        assertNotNull(facture);
    }

    @Test
    public void testSettersAndGetters() {
        Facture facture = new Facture();
        facture.setMontantFacture(100.0f);
        facture.setMontantRemise(10.0f);

        assertEquals(100.0, facture.getMontantFacture(), 0.001);
        assertEquals(10.0, facture.getMontantRemise(), 0.001);

    }
}
