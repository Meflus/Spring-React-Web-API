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
public class CharacterDto {
    private Long id;
    private String characterName;
    private String characterBackstory;
    private Boolean isActive;
    private Integer characterLevel;
    private Integer proficiencyBonus;
    private ClassEntity classEntity;
    private SpeciesEntity speciesEntity;
}
