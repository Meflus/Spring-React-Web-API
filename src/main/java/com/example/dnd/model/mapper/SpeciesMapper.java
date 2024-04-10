package com.example.dnd.model.mapper;

import com.example.dnd.model.dto.SpeciesDto;
import com.example.dnd.model.entity.SpeciesEntity;

public class SpeciesMapper {
    public static SpeciesDto mapToDto(SpeciesEntity speciesEntity) {
        return new SpeciesDto(
                speciesEntity.getId(),
                speciesEntity.getSpeciesName(),
                speciesEntity.getSpeciesSize(),
                speciesEntity.getSpeciesDescription(),
                speciesEntity.getCharacters(),
                speciesEntity.getFeatures()
        );
    }

    public static SpeciesEntity mapToEntity(SpeciesDto speciesDto) {
        return new SpeciesEntity(
                speciesDto.getId(),
                speciesDto.getSpeciesName(),
                speciesDto.getSpeciesSize(),
                speciesDto.getSpeciesDescription(),
                speciesDto.getCharacters(),
                speciesDto.getFeatures()
        );
    }
}
