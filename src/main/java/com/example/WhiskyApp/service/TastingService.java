package com.example.WhiskyApp.service;

import com.example.WhiskyApp.dto.TastingRequest;
import com.example.WhiskyApp.dto.TastingUpdateRequest;
import com.example.WhiskyApp.entity.Tasting;
import com.example.WhiskyApp.repository.TastingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;

@Service
public class TastingService {

    private final TastingRepository tastingRepository;

    public TastingService(TastingRepository tastingRepository) {
        this.tastingRepository = tastingRepository;
    }

    public Tasting createTasting(TastingRequest request) {
        String imageUrl = (request.getImageUrl() != null && !request.getImageUrl().isEmpty())
                ? request.getImageUrl()
                : "images/default_tasting.jpg";

        Tasting tasting = new Tasting(request.getName(), request.getDate(), imageUrl, request.getDescription());
        return tastingRepository.save(tasting);
    }

    public Tasting updateTasting(Long id, TastingUpdateRequest request) {
        Tasting existing = tastingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tasting not found"));

        String imageUrl = (request.getImageUrl() != null && !request.getImageUrl().isEmpty())
                ? request.getImageUrl()
                : "images/default_tasting.jpg";

        Tasting updated = new Tasting(request.getName(), request.getDate(), imageUrl, request.getDescription());

        try {
            Field idField = Tasting.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(updated, id);
        } catch (Exception e) {
            throw new RuntimeException("Konnte ID nicht setzen", e);
        }

        return tastingRepository.save(updated);
    }

    public void deleteTasting(Long id) {
        Tasting tasting = tastingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tasting not found"));
        tastingRepository.delete(tasting);
    }
}
