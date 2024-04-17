package com.example.dnd.controller;

import com.example.dnd.model.dto.CharacterDto;
import com.example.dnd.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/characters")
public class CharacterController {
    private CharacterService characterService;

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<CharacterDto> createCharacter(@RequestParam("file") MultipartFile file, @ModelAttribute CharacterDto characterDto) {
        if (!file.isEmpty()) {
            try {
                characterDto.setCharacterImage(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getCharacterImage(@PathVariable("id") Long id) {
        byte[] image = characterService.getCharacterImageById(id);
        return ResponseEntity.ok().contentType(MediaType.ALL).body(image);
    }
}
