package com.example.WhiskyApp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Value("${image.upload.dir}")
    private String uploadDir;

    @GetMapping("/list")
    public ResponseEntity<List<String>> listImages() {
        try {
            Path dirPath = Paths.get(uploadDir);

            if (!Files.exists(dirPath)) {
                return ResponseEntity.ok(Collections.emptyList());
            }

            // Alle Dateien auflisten
            /*List<String> imageUrls = Files.list(dirPath)
                    .filter(Files::isRegularFile)
                    .map(path -> "/images/" + path.getFileName().toString())
                    .toList();*/

            // Nur Bilddateien zulassen
            List<String> imageUrls = Files.list(dirPath)
                    .filter(Files::isRegularFile)
                    .filter(path -> {
                        String fileName = path.getFileName().toString().toLowerCase();
                        return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") ||
                                fileName.endsWith(".png") || fileName.endsWith(".gif") ||
                                fileName.endsWith(".webp");
                    })
                    .map(path -> "/images/" + path.getFileName().toString())
                    .toList();

            return ResponseEntity.ok(imageUrls);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
