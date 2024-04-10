package com.example.dnd.service.impl;

import com.example.dnd.exception.ResourceNotFoundException;
import com.example.dnd.model.dto.SpeciesDto;
import com.example.dnd.model.entity.SpeciesEntity;
import com.example.dnd.model.mapper.SpeciesMapper;
import com.example.dnd.repository.SpeciesRepository;
import com.example.dnd.service.SpeciesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SpeciesServiceImpl implements SpeciesService {
    private SpeciesRepository speciesRepository;

    @Override
    public SpeciesDto createSpecies(SpeciesDto speciesDto) {
        return SpeciesMapper.mapToDto(this.speciesRepository.save(SpeciesMapper.mapToEntity(speciesDto)));
    }

    @Override
    public SpeciesDto getSpeciesById(Long id) {
        return SpeciesMapper.mapToDto(this.speciesRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Espécie de ID " + id + " não foi encontrada ou não existe!")));
    }

    @Override
    public List<SpeciesDto> getAllSpecies() {
        return this.speciesRepository.findAll().stream().map(SpeciesMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public SpeciesDto updateSpecies(Long id, SpeciesDto speciesDto) {
        SpeciesEntity speciesEntity = this.speciesRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Espécie de ID " + id + " não foi encontrada ou não existe!"));
        speciesEntity.setSpeciesName(speciesDto.getSpeciesName());
        speciesEntity.setSpeciesSize(speciesDto.getSpeciesSize());
        speciesEntity.setSpeciesDescription(speciesDto.getSpeciesDescription());
        return SpeciesMapper.mapToDto(speciesRepository.save(speciesEntity));
    }

    @Override
    public void deleteSpeciesById(Long id) {
        SpeciesEntity speciesEntity = this.speciesRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Espécie de ID " + id + " não foi encontrada ou não existe!"));
        this.speciesRepository.deleteById(speciesEntity.getId());
    }
}
