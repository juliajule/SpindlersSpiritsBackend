package com.example.WhiskyApp.service;

import com.example.WhiskyApp.dto.WhiskyRequest;
import com.example.WhiskyApp.dto.WhiskyUpdateRequest;
import com.example.WhiskyApp.entity.Whisky;
import com.example.WhiskyApp.entity.Tasting;
import com.example.WhiskyApp.repository.TastingRepository;
import com.example.WhiskyApp.repository.WhiskyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;

@Service
public class WhiskyService {

    private final WhiskyRepository whiskyRepository;
    private final TastingRepository tastingRepository;

    public WhiskyService(WhiskyRepository whiskyRepository, TastingRepository tastingRepository) {
        this.whiskyRepository = whiskyRepository;
        this.tastingRepository = tastingRepository;
    }

    public Whisky createWhisky(WhiskyRequest request) {
        Tasting tasting = tastingRepository.findById(request.getTastingId())
                .orElseThrow(() -> new RuntimeException("Tasting nicht gefunden"));

        Whisky whisky = new Whisky(
                request.getName(),
                request.getDistillery(),
                request.getAge(),
                request.getAlcoholPercentage(),
                request.getDescription(),
                request.getImageUrl(),
                tasting
        );
        return whiskyRepository.save(whisky);
    }

    public Whisky updateWhisky(Long id, WhiskyUpdateRequest request) {
        Whisky whisky = whiskyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Whisky mit ID " + id + " nicht gefunden"));

        Tasting tasting = tastingRepository.findById(request.getTastingId())
                .orElseThrow(() -> new RuntimeException("Tasting mit ID " + request.getTastingId() + " nicht gefunden"));

        whisky = new Whisky(
                request.getName(),
                request.getDistillery(),
                request.getAge(),
                request.getAlcoholPercentage(),
                request.getDescription(),
                request.getImageUrl(),
                tasting
        );

        Field idField;
        try {
            idField = Whisky.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(whisky, id);
        } catch (Exception e) {
            throw new RuntimeException("Konnte ID nicht setzen", e);
        }
        return whiskyRepository.save(whisky);
    }

    public void deleteWhisky(Long id) {
        Whisky whisky = whiskyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Whisky not found"));

        whiskyRepository.delete(whisky);
    }
}