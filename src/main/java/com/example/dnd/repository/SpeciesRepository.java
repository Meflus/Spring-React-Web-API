package com.example.dnd.repository;

import com.example.dnd.model.entity.SpeciesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<SpeciesEntity, Long> {
}
