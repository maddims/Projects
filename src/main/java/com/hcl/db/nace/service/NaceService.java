package com.hcl.db.nace.service;

import com.hcl.db.nace.bean.Nace;
import com.hcl.db.nace.exception.NaceDetailsNotFoundException;
import com.hcl.db.nace.repository.NaceRepository;
import org.springframework.stereotype.Service;

@Service
public class NaceService {

    private final NaceRepository naceRepository;

    public NaceService(NaceRepository naceRepository) {
        this.naceRepository = naceRepository;
    }

    public Nace getNaceDetails(String naceCode) {
        Nace nace = naceRepository.findByNaceCode(naceCode);
        if (nace == null) {
            throw new NaceDetailsNotFoundException();
        }
        return nace;
    }
}
