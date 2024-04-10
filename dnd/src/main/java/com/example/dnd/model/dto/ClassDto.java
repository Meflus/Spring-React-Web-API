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
public class ClassDto {
    private Long id;
    private String className;
    private String classHitDie;
    private String classDescription;
    private List<CharacterEntity> characters;
    private List<FeatureEntity> features;
}
