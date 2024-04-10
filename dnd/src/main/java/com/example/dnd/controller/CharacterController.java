package com.example.dnd.controller;

import com.example.dnd.model.dto.CharacterDto;
import com.example.dnd.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/characters")
public class CharacterController {
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<CharacterDto> createCharacter(@RequestBody CharacterDto characterDto) {
        return new ResponseEntity<>(this.characterService.createCharacter(characterDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CharacterDto> getCharacterById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.characterService.getCharacterById(id));
    }

    @GetMapping
    public ResponseEntity<List<CharacterDto>> getAllCharacters() {
        return ResponseEntity.ok(this.characterService.getAllCharacters());
    }

    @PutMapping("{id}")
    public ResponseEntity<CharacterDto> updateCharacter(@PathVariable("id") Long id, @RequestBody CharacterDto characterDto) {
        return ResponseEntity.ok(this.characterService.updateCharacter(id, characterDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCharacterById(@PathVariable("id") Long id) {
        this.characterService.deleteCharacterById(id);
        return ResponseEntity.ok("Personagem de ID " + id + " removido com sucesso!");
    }
}
