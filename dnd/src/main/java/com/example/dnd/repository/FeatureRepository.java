package com.example.dnd.repository;

import com.example.dnd.model.entity.FeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<FeatureEntity, Long> {
}
