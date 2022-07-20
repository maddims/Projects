package com.hcl.db.nace.service;

import com.hcl.db.nace.bean.Nace;
import com.hcl.db.nace.exception.NaceDetailsNotFoundException;
import com.hcl.db.nace.repository.NaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith({MockitoExtension.class})
class NaceServiceTest {

    @Mock
    private NaceRepository naceRepository;

    private NaceService naceService;

    @BeforeEach
    public void setUp() {
        naceService = new NaceService(naceRepository);
    }

    @Test
    void getNaceDetails_shouldReturnNaceDetails() {

        given(naceRepository.findByNaceCode("A")).willReturn(Nace.builder().level("1").description("AGRICULTURE, FORESTRY AND FISHING").build());
        Nace nace = naceService.getNaceDetails("A");
        assertThat(nace).isNotNull();
        assertThat(nace.getLevel()).isEqualTo("1");
        assertThat(nace.getDescription()).isEqualTo("AGRICULTURE, FORESTRY AND FISHING");

    }

    @Test
    void getNaceDetails_notFound(){
        given(naceRepository.findByNaceCode("A")).willReturn(null);
        Exception exception = assertThrows(NaceDetailsNotFoundException.class, () -> naceService.getNaceDetails("A"));
        assertThat(exception).isInstanceOf(NaceDetailsNotFoundException.class);

    }


}