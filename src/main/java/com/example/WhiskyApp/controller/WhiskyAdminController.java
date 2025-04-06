package com.example.WhiskyApp.controller;

import com.example.WhiskyApp.dto.*;
import com.example.WhiskyApp.service.*;
import com.example.WhiskyApp.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/whiskys")
public class WhiskyAdminController {

    private final WhiskyService whiskyService;

    public WhiskyAdminController(WhiskyService whiskyService) {
        this.whiskyService = whiskyService;
    }

    @PostMapping
    public ResponseEntity<Whisky> create(@RequestBody WhiskyRequest request) {
        return new ResponseEntity<>(whiskyService.createWhisky(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Whisky> updateWhisky(@PathVariable Long id, @RequestBody WhiskyUpdateRequest request) {
        Whisky updated = whiskyService.updateWhisky(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        whiskyService.deleteWhisky(id);
        return ResponseEntity.noContent().build();
    }
}
