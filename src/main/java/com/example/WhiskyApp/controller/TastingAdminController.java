package com.example.WhiskyApp.controller;

import com.example.WhiskyApp.dto.TastingRequest;
import com.example.WhiskyApp.dto.TastingUpdateRequest;
import com.example.WhiskyApp.entity.Tasting;
import com.example.WhiskyApp.service.TastingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/tastings")
public class TastingAdminController {

    private final TastingService tastingService;

    public TastingAdminController(TastingService tastingService) {
        this.tastingService = tastingService;
    }

    @PostMapping
    public ResponseEntity<Tasting> createTasting(@RequestBody TastingRequest request) {
        Tasting saved = tastingService.createTasting(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tasting> updateTasting(@PathVariable Long id, @RequestBody TastingUpdateRequest request) {
        Tasting updated = tastingService.updateTasting(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTasting(@PathVariable Long id) {
        tastingService.deleteTasting(id);
        return ResponseEntity.noContent().build();
    }
}