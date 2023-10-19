package com.esprit.examen.services;

import com.esprit.examen.entities.Fournisseur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class FournisseurServiceImplTest {
IFournisseurService fs;
    @Test
    @Order(1)
     void testRetrieveAllFournisseurs() {
            List<Fournisseur> listUsers = fs.retrieveAllFournisseurs();
            Assertions.assertEquals(0, listUsers.size());

    }

}