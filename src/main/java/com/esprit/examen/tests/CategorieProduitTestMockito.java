package com.esprit.examen.tests;

import com.esprit.examen.controllers.CategorieProduitController;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.services.ICategorieProduitService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CategorieProduitTestMockito {

    @Mock
    private ICategorieProduitService categorieProduitService;

    @InjectMocks
    private CategorieProduitController categorieProduitController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(categorieProduitController).build();
    }

    @Test
    public void testRetrieveAllCategorieProduits() throws Exception {
        CategorieProduit cp1 = new CategorieProduit(
                1L, // idCategorieProduit
                "CP001", // codeCategorie
                "Electronics", // libelleCategorie
                null // produits - assuming it's okay to be null for your test
        );
        CategorieProduit cp2 = new CategorieProduit(
                2L, // idCategorieProduit
                "CP002", // codeCategorie
                "Household", // libelleCategorie
                null // produits - assuming it's okay to be null for your test
        );
        List<CategorieProduit> categorieProduits = Arrays.asList(cp1, cp2);

        given(categorieProduitService.retrieveAllCategorieProduits()).willReturn(categorieProduits);

        mockMvc.perform(get("/categorieProduit/retrieve-all-categorieProduit")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(categorieProduits.size()));

        verify(categorieProduitService).retrieveAllCategorieProduits();
    }

    @Test
    public void testAddCategorieProduit() throws Exception {
        CategorieProduit newCp = new CategorieProduit(
                1L, // idCategorieProduit
                "CP100", // codeCategorie
                "Groceries", // libelleCategorie
                new HashSet<>() // produits
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String newCpJson = objectMapper.writeValueAsString(newCp);

        // Use any() to accept any CategorieProduit object
        given(categorieProduitService.addCategorieProduit(any(CategorieProduit.class))).willReturn(newCp);

        mockMvc.perform(post("/categorieProduit/add-categorieProduit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newCpJson))
                .andExpect(status().isOk());

        // Verify with any() matcher
        verify(categorieProduitService).addCategorieProduit(any(CategorieProduit.class));
    }
}
