package com.example.dnd.service;

import com.example.dnd.model.dto.CharacterDto;

import java.util.List;

public interface CharacterService {
    CharacterDto createCharacter(CharacterDto characterDto);

    CharacterDto getCharacterById(Long id);

    List<CharacterDto> getAllCharacters();

    CharacterDto updateCharacter(Long id, CharacterDto characterDto);

    void deleteCharacterById(Long id);

    byte[] getCharacterImageById(Long id);
}
