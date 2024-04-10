package com.example.dnd.model.dto;

import com.example.dnd.model.entity.CharacterEntity;
import com.example.dnd.model.entity.FeatureEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpeciesDto {
    private Long id;
    private String speciesName;
    private Integer speciesSize;
    private String speciesDescription;
    private List<CharacterEntity> characters;
    private List<FeatureEntity> features;
}
