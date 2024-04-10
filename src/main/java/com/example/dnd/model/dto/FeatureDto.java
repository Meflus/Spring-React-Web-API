package com.example.dnd.model.dto;

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
    private Long classEntityId;
    private Long speciesEntityId;
}
