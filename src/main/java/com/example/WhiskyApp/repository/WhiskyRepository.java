package com.example.WhiskyApp.repository;

import com.example.WhiskyApp.entity.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WhiskyRepository extends JpaRepository<Whisky, Long>, JpaSpecificationExecutor<Whisky> {
}