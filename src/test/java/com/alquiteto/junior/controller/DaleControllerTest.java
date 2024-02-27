package com.alquiteto.junior.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DaleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCustom_onFirstTwoRequests_returnUNPROCESSABLE_ENTITY() throws Exception {
        MvcResult firstRequestMvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/random"))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
                .andReturn();

        MvcResult secondRequestMvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/random"))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity())
                .andReturn();

        MvcResult thirdRequestMvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/random"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertThat(secondRequestMvcResult.getResponse().getContentAsString()).isEqualTo("Status Aleatório:422 UNPROCESSABLE_ENTITY");
        assertThat(firstRequestMvcResult.getResponse().getContentAsString()).isEqualTo("Status Aleatório:422 UNPROCESSABLE_ENTITY");
        assertThat(thirdRequestMvcResult.getResponse().getContentAsString()).isEqualTo("Status Aleatório:200 OK");

    }

}