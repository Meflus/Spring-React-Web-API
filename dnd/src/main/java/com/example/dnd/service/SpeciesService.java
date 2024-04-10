package com.example.dnd.service;

import com.example.dnd.model.dto.SpeciesDto;

import java.util.List;

public interface SpeciesService {
    SpeciesDto createSpecies(SpeciesDto speciesDto);

    SpeciesDto getSpeciesById(Long id);

    List<SpeciesDto> getAllSpecies();

    SpeciesDto updateSpecies(Long id, SpeciesDto speciesDto);

    void deleteSpeciesById(Long id);
}
