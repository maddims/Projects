package com.hcl.db.nace.controller;

import com.hcl.db.nace.bean.Nace;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class NaceController {

    @GetMapping("/nace/{naceCode}")
    public ResponseEntity<Nace> getNaceDetails(@PathVariable String naceCode) {
        return ResponseEntity.ok(Nace.builder().level("1").description("AGRICULTURE, FORESTRY AND FISHING").build());
    }
}
