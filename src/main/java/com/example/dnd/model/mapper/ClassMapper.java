package com.example.dnd.model.mapper;

import com.example.dnd.model.dto.ClassDto;
import com.example.dnd.model.entity.ClassEntity;

public class ClassMapper {
    public static ClassDto mapToDto(ClassEntity classEntity) {
        return new ClassDto(
                classEntity.getId(),
                classEntity.getClassName(),
                classEntity.getClassHitDie(),
                classEntity.getClassDescription(),
                classEntity.getCharacters(),
                classEntity.getFeatures()
        );
    }

    public static ClassEntity mapToEntity(ClassDto classDto) {
        return new ClassEntity(
                classDto.getId(),
                classDto.getClassName(),
                classDto.getClassHitDie(),
                classDto.getClassDescription(),
                classDto.getCharacters(),
                classDto.getFeatures()
        );
    }
}
