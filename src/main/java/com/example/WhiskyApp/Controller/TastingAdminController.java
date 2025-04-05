package com.example.WhiskyApp.Controller;

import com.example.WhiskyApp.DTO.TastingRequest;
import com.example.WhiskyApp.Entity.Tasting;
import com.example.WhiskyApp.Repositories.TastingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/tastings")
public class TastingAdminController {

    private final TastingRepository tastingRepository;

    public TastingAdminController(TastingRepository tastingRepository) {
        this.tastingRepository = tastingRepository;
    }

    @PostMapping
    public ResponseEntity<Tasting> createTasting(@RequestBody TastingRequest request) {
        String imageUrl = (request.getImageUrl() != null && !request.getImageUrl().isEmpty())
                ? request.getImageUrl()
                : "images/default_tasting.jpg";

        Tasting tasting = new Tasting(request.getName(), request.getDate(), imageUrl);
        Tasting saved = tastingRepository.save(tasting);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
