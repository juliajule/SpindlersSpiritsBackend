package com.example.WhiskyApp.repository;

import com.example.WhiskyApp.entity.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
}