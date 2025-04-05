package com.example.WhiskyApp.Controller;

import com.example.WhiskyApp.DTO.WhiskyRequest;
import com.example.WhiskyApp.Entity.Tasting;
import com.example.WhiskyApp.Entity.Whisky;
import com.example.WhiskyApp.Repositories.TastingRepository;
import com.example.WhiskyApp.Repositories.WhiskyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/admin/whiskys")
public class WhiskyAdminController {

    private final WhiskyRepository whiskyRepository;
    private final TastingRepository tastingRepository;

    public WhiskyAdminController(WhiskyRepository whiskyRepository, TastingRepository tastingRepository) {
        this.whiskyRepository = whiskyRepository;
        this.tastingRepository = tastingRepository;
    }

    @PostMapping
    public ResponseEntity<?> createWhisky(@RequestBody WhiskyRequest request) {
        Optional<Tasting> tastingOpt = tastingRepository.findById(request.getTastingId());

        if (tastingOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tasting not found");
        }

        String imageUrl = (request.getImageUrl() != null && !request.getImageUrl().isEmpty())
                ? request.getImageUrl()
                : "images/default_whisky.jpg";

        Whisky whisky = new Whisky(
                request.getName(),
                request.getDistillery(),
                request.getAge(),
                request.getAlcoholPercentage(),
                request.getDescription(),
                imageUrl,
                tastingOpt.get()
        );

        Whisky saved = whiskyRepository.save(whisky);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
