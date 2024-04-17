package com.example.dnd.model.dto;

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
    private Long classEntityId;
    private Long speciesEntityId;
    private byte[] characterImage;
}
