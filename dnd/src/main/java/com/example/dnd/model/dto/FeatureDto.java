package com.example.dnd.model.dto;

import com.example.dnd.model.entity.ClassEntity;
import com.example.dnd.model.entity.SpeciesEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeatureDto {
    private Long id;
    private String featureName;
    private String featureDescription;
    private Integer levelRequirement;
    private ClassEntity classEntity;
    private SpeciesEntity speciesEntity;
}
