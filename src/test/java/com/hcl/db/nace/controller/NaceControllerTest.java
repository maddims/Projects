package com.hcl.db.nace.controller;

import com.hcl.db.nace.bean.Nace;
import com.hcl.db.nace.exception.NaceDetailsNotFoundException;
import com.hcl.db.nace.service.NaceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class NaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NaceService naceService;

    @Test
    void getNaceDetails_shouldReturnNaceDetails() throws Exception {

        given(naceService.getNaceDetails(anyString())).willReturn(Nace.builder().level("1").description("AGRICULTURE, FORESTRY AND FISHING").build());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/nace/A"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("level").value("1"))
                .andExpect(jsonPath("description").value("AGRICULTURE, FORESTRY AND FISHING"));
    }

    @Test
    void getNaceDetails_notFound()throws Exception{
        given(naceService.getNaceDetails(anyString())).willThrow(new NaceDetailsNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/nace/A"))
                .andExpect(status().isNotFound());
    }
}
