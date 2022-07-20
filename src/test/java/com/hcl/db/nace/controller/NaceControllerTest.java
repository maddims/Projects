package com.hcl.db.nace.controller;

import com.hcl.db.nace.bean.Nace;
import com.hcl.db.nace.exception.NaceDetailsNotFoundException;
import com.hcl.db.nace.service.NaceService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
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

        given(naceService.getNaceDetails(anyString())).willReturn(Nace.builder()
                .level("1")
                .description("AGRICULTURE, FORESTRY AND FISHING")
                .naceCode("A")
                .order("398481")
                .thisItemIncludes("This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants")
                .build());

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

    @Test
    void givenNaceDetails_putNaceDetails_shouldSaveNaceDetailsToDb() throws Exception {
        JSONObject naceJsonObject = new JSONObject();
        naceJsonObject.put("level","1");
        naceJsonObject.put("naceCode","A");
        naceJsonObject.put("description","AGRICULTURE, FORESTRY AND FISHING");

        given(naceService.putNaceDetails(any())).willReturn(Nace.builder()
                .level("1")
                .description("AGRICULTURE, FORESTRY AND FISHING")
                .naceCode("A")
                .order("398481")
                .thisItemIncludes("This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants")
                .build());


        mockMvc.perform(MockMvcRequestBuilders.post("/api/nace/putNaceDetails").contentType(MediaType.APPLICATION_JSON).content(naceJsonObject.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("level").value("1"))
                .andExpect(jsonPath("naceCode").value("A"))
                .andExpect(jsonPath("description").value("AGRICULTURE, FORESTRY AND FISHING"));
    }
}
