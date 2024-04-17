package com.example.dnd.model.mapper;

import com.example.dnd.model.dto.CharacterDto;
import com.example.dnd.model.entity.CharacterEntity;

public class CharacterMapper {
    public static CharacterDto mapToDto(CharacterEntity characterEntity) {
        return new CharacterDto(
                characterEntity.getId(),
                characterEntity.getCharacterName(),
                characterEntity.getCharacterBackstory(),
                characterEntity.getIsActive(),
                characterEntity.getCharacterLevel(),
                characterEntity.getProficiencyBonus(),
                characterEntity.getClassEntityId(),
                characterEntity.getSpeciesEntityId(),
                characterEntity.getCharacterImage()
                );
    }

    public static CharacterEntity mapToEntity(CharacterDto characterDto) {
        return new CharacterEntity(
                characterDto.getId(),
                characterDto.getCharacterName(),
                characterDto.getCharacterBackstory(),
                characterDto.getIsActive(),
                characterDto.getCharacterLevel(),
                characterDto.getProficiencyBonus(),
                characterDto.getClassEntityId(),
                characterDto.getSpeciesEntityId(),
                characterDto.getCharacterImage()
        );
    }
}
