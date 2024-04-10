package com.example.dnd.service.impl;

import com.example.dnd.exception.ResourceNotFoundException;
import com.example.dnd.model.dto.FeatureDto;
import com.example.dnd.model.entity.FeatureEntity;
import com.example.dnd.model.mapper.FeatureMapper;
import com.example.dnd.repository.FeatureRepository;
import com.example.dnd.service.FeatureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FeaturesServiceImpl implements FeatureService {
    private FeatureRepository featureRepository;

    @Override
    public FeatureDto createFeature(FeatureDto featureDto) {
        return FeatureMapper.mapToDto(this.featureRepository.save(FeatureMapper.mapToEntity(featureDto)));
    }

    @Override
    public FeatureDto getFeatureById(Long id) {
        return FeatureMapper.mapToDto(this.featureRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Feature de ID " + id + " não foi encontrada ou não existe!")));
    }

    @Override
    public List<FeatureDto> getAllFeatures() {
        return this.featureRepository.findAll().stream().map(FeatureMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public FeatureDto updateFeature(Long id, FeatureDto featureDto) {
        FeatureEntity featureEntity = this.featureRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Feature de ID " + id + " não foi encontrada ou não existe!"));
        featureEntity.setFeatureDescription(featureDto.getFeatureDescription());
        featureEntity.setFeatureName(featureDto.getFeatureName());
        featureEntity.setLevelRequirement(featureDto.getLevelRequirement());
        return FeatureMapper.mapToDto(this.featureRepository.save(featureEntity));
    }

    @Override
    public void deleteFeatureById(Long id) {
        FeatureEntity featureEntity = this.featureRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Feature de ID " + id + " não foi encontrada ou não existe!"));
        this.featureRepository.deleteById(featureEntity.getId());
    }
}
