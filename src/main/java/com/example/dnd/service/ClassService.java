package com.example.dnd.service;

import com.example.dnd.model.dto.ClassDto;

import java.util.List;

public interface ClassService {
    ClassDto createClass(ClassDto classDto);

    ClassDto getClassById(Long id);

    List<ClassDto> getAllClasses();

    ClassDto updateClass(Long id, ClassDto classDto);

    void deleteClassById(Long id);
}
