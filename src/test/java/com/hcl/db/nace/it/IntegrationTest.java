package com.hcl.db.nace.it;

import com.hcl.db.nace.bean.Nace;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void givenNaceCode_getNaceDetails_shouldReturnNaceDetailsForGivenNaceCode() {

        ResponseEntity<Nace> response = restTemplate.getForEntity("/api/nace/A", Nace.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getLevel()).isEqualTo("1");
        assertThat(response.getBody().getDescription()).isEqualTo("AGRICULTURE, FORESTRY AND FISHING");
    }
}
