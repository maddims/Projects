package com.hcl.db.nace.controller;

import com.hcl.db.nace.bean.Nace;
import com.hcl.db.nace.exception.NaceDetailsNotFoundException;
import com.hcl.db.nace.service.NaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class NaceController {

    @Autowired
    private NaceService naceService;
    @GetMapping("/nace/{naceCode}")
    public ResponseEntity<Nace> getNaceDetails(@PathVariable String naceCode) {
        return ResponseEntity.ok(naceService.getNaceDetails(naceCode));
    }

    @PostMapping("/nace/putNaceDetails")
    public ResponseEntity<Nace> putNaceDetails(@RequestBody Nace nace){
        return  ResponseEntity.ok(naceService.putNaceDetails(nace));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void naceDetailsNotFoundException(NaceDetailsNotFoundException exception){

    }
}
