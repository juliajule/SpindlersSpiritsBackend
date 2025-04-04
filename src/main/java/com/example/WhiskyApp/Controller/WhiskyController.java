package com.example.WhiskyApp.Controller;

import com.example.WhiskyApp.Entity.Whisky;
import com.example.WhiskyApp.Repositories.WhiskyRepository;
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
}