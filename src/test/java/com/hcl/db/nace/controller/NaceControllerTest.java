package com.hcl.db.nace.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class NaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getNaceDetails_shouldReturnNaceDetails() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/nace/A"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("level").value("1"))
                .andExpect(jsonPath("description").value("AGRICULTURE, FORESTRY AND FISHING"));
    }
}
