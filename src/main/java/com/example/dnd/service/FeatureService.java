package com.example.dnd.service;

import com.example.dnd.model.dto.FeatureDto;

import java.util.List;

public interface FeatureService {
    FeatureDto createFeature(FeatureDto featureDto);

    FeatureDto getFeatureById(Long id);

    List<FeatureDto> getAllFeatures();

    FeatureDto updateFeature(Long id, FeatureDto featureDto);
    void deleteFeatureById(Long id);
}
