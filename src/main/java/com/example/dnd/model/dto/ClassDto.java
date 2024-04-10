package com.example.dnd.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassDto {
    private Long id;
    private String className;
    private String classHitDie;
    private String classDescription;
}
