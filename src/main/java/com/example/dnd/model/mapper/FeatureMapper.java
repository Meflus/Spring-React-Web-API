package com.example.dnd.model.mapper;

import com.example.dnd.model.dto.FeatureDto;
import com.example.dnd.model.entity.FeatureEntity;

public class FeatureMapper {
    public static FeatureDto mapToDto(FeatureEntity featureEntity) {
        return new FeatureDto(
                featureEntity.getId(),
                featureEntity.getFeatureName(),
                featureEntity.getFeatureDescription(),
                featureEntity.getLevelRequirement(),
                featureEntity.getClassEntityId(),
                featureEntity.getSpeciesEntityId()
        );
    }

    public static FeatureEntity mapToEntity(FeatureDto featureDto) {
        return new FeatureEntity(
                featureDto.getId(),
                featureDto.getFeatureName(),
                featureDto.getFeatureDescription(),
                featureDto.getLevelRequirement(),
                featureDto.getClassEntityId(),
                featureDto.getSpeciesEntityId()
        );
    }
}
