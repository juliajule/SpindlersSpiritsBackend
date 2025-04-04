package com.example.WhiskyApp.Repositories;

import com.example.WhiskyApp.Entity.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
}