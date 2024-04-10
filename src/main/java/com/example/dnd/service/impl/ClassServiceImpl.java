package com.example.dnd.service.impl;

import com.example.dnd.exception.ResourceNotFoundException;
import com.example.dnd.model.dto.ClassDto;
import com.example.dnd.model.entity.ClassEntity;
import com.example.dnd.model.mapper.ClassMapper;
import com.example.dnd.repository.ClassRepository;
import com.example.dnd.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClassServiceImpl implements ClassService {
    private ClassRepository classRepository;

    @Override
    public ClassDto createClass(ClassDto classDto) {
        return ClassMapper.mapToDto(this.classRepository.save(ClassMapper.mapToEntity(classDto)));
    }

    @Override
    public ClassDto getClassById(Long id) {
        return ClassMapper.mapToDto(this.classRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Classe de ID " + id + " não foi encontrada ou não existe!")));
    }

    @Override
    public List<ClassDto> getAllClasses() {
        return this.classRepository.findAll().stream().map(ClassMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public ClassDto updateClass(Long id, ClassDto classDto) {
        ClassEntity classEntity = this.classRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Classe de ID " + id + " não foi encontrada ou não existe!"));
        classEntity.setClassName(classDto.getClassName());
        classEntity.setClassHitDie(classDto.getClassHitDie());
        classEntity.setClassDescription(classDto.getClassDescription());
        return ClassMapper.mapToDto(this.classRepository.save(classEntity));
    }

    @Override
    public void deleteClassById(Long id) {
        ClassEntity classEntity = this.classRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Classe de ID " + id + " não foi encontrada ou não existe!"));
        this.classRepository.deleteById(classEntity.getId());
    }
}
