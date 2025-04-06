package com.example.WhiskyApp.controller;

import com.example.WhiskyApp.entity.Tasting;
import com.example.WhiskyApp.repository.TastingRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tastings")
public class TastingController {

    private final TastingRepository tastingRepository;

    public TastingController(TastingRepository tastingRepository) {
        this.tastingRepository = tastingRepository;
    }

    @GetMapping
    public List<Tasting> getAllTastings() {
        return tastingRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tasting getTastingById(@PathVariable Long id) {
        return tastingRepository.findById(id).orElseThrow(() -> new RuntimeException("Tasting not found"));
    }
}
