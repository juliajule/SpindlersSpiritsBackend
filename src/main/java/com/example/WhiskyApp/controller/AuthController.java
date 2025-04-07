package com.example.WhiskyApp.controller;

import com.example.WhiskyApp.config.AdminCredentialsConfig;
import com.example.WhiskyApp.dto.LoginRequest;
import com.example.WhiskyApp.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AdminCredentialsConfig credentials;

    public AuthController(JwtUtil jwtUtil, AdminCredentialsConfig credentials) {
        this.jwtUtil = jwtUtil;
        this.credentials = credentials;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        if (credentials.getUsername().equals(request.getUsername())
                && credentials.getPassword().equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Ungültige Zugangsdaten");
        }
    }
}