package com.example.WhiskyApp.controller;

import com.example.WhiskyApp.dto.WhiskySearchRequest;
import com.example.WhiskyApp.entity.Whisky;
import com.example.WhiskyApp.repository.WhiskyRepository;
import com.example.WhiskyApp.specification.WhiskySpecification;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/whiskys")
public class WhiskyController {

    private final WhiskyRepository whiskyRepository;

    public WhiskyController(WhiskyRepository whiskyRepository) {
        this.whiskyRepository = whiskyRepository;
    }

    @GetMapping
    public List<Whisky> getAllWhiskys() {
        return whiskyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Whisky getWhiskyById(@PathVariable Long id) {
        return whiskyRepository.findById(id).orElseThrow(() -> new RuntimeException("Whisky not found"));
    }

    @PostMapping("/search")
    public List<Whisky> searchWhiskys(@RequestBody WhiskySearchRequest searchRequest) {
        return whiskyRepository.findAll(WhiskySpecification.bySearchRequest(searchRequest));
    }
}