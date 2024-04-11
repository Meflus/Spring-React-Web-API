package com.example.dnd.service.impl;

import com.example.dnd.exception.ResourceNotFoundException;
import com.example.dnd.model.dto.CharacterDto;
import com.example.dnd.model.entity.CharacterEntity;
import com.example.dnd.model.mapper.CharacterMapper;
import com.example.dnd.repository.CharacterRepository;
import com.example.dnd.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CharacterServiceImpl implements CharacterService {
    private CharacterRepository characterRepository;

    @Override
    public CharacterDto createCharacter(CharacterDto characterDto) {
        characterDto.setCharacterLevel(1);
        characterDto.setProficiencyBonus(2);
        characterDto.setIsActive(true);
        return CharacterMapper.mapToDto(this.characterRepository.save(CharacterMapper.mapToEntity(characterDto)));
    }

    @Override
    public CharacterDto getCharacterById(Long id) {
        return CharacterMapper.mapToDto(this.characterRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Personagem de ID " + id + " não foi encontrado ou não existe!")));
    }

    @Override
    public List<CharacterDto> getAllCharacters() {
        return this.characterRepository.findAll().stream().map(CharacterMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public CharacterDto updateCharacter(Long id, CharacterDto characterDto) {
        CharacterEntity characterEntity = this.characterRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Personagem de ID " + id + " não foi encontrado ou não existe!"));

        if (!characterDto.getCharacterBackstory().isBlank()) {
            characterEntity.setCharacterBackstory(characterDto.getCharacterBackstory());
        }
        if (characterDto.getCharacterLevel() != null) {
            characterEntity.setCharacterLevel(characterDto.getCharacterLevel());
        }
        if (!characterDto.getCharacterName().isBlank()) {
            characterEntity.setCharacterName(characterDto.getCharacterName());
        }
        if (characterDto.getClassEntityId() != null) {
            characterEntity.setClassEntityId(characterDto.getClassEntityId());
        }
        if (characterDto.getSpeciesEntityId() != null) {
            characterEntity.setSpeciesEntityId(characterDto.getSpeciesEntityId());
        }

        if (characterDto.getCharacterLevel() >= 1 && characterDto.getCharacterLevel() < 5) {
            characterEntity.setProficiencyBonus(2);
        } else if (characterDto.getCharacterLevel() >= 5 && characterDto.getCharacterLevel() < 9) {
            characterEntity.setProficiencyBonus(3);
        } else if (characterDto.getCharacterLevel() >= 9 && characterDto.getCharacterLevel() < 13) {
            characterEntity.setProficiencyBonus(4);
        } else if (characterDto.getCharacterLevel() >= 13 && characterDto.getCharacterLevel() < 17) {
            characterEntity.setProficiencyBonus(5);
        } else if (characterDto.getCharacterLevel() >= 17) {
            characterEntity.setProficiencyBonus(6);
        }

        return CharacterMapper.mapToDto(this.characterRepository.save(characterEntity));
    }

    @Override
    public void deleteCharacterById(Long id) {
        CharacterEntity characterEntity = this.characterRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Personagem de ID " + id + " não foi encontrado ou não existe!"));
        this.characterRepository.deleteById(characterEntity.getId());
    }
}
