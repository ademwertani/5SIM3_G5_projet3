package com.esprit.examen.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testng.Assert.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
public class CategorieProduitTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRetrieveAllCategorieProduits() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/categorieProduit/retrieve-all-categorieProduit")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        assertNotNull(content);
        // More assertions can be added based on the expected JSON structure
    }

    @Test
    public void testAddCategorieProduit() throws Exception {
        String categorieProduitJson = "{\"codeCategorie\":\"TestCode\",\"libelleCategorie\":\"TestLibelle\"}";
        mockMvc.perform(post("/categorieProduit/add-categorieProduit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(categorieProduitJson))
                .andExpect(status().isOk());
        // You can also perform further checks on the returned object
    }

    // Add other test methods for retrieve, update, and delete operations
}
