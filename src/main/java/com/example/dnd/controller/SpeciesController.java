package com.example.dnd.controller;

import com.example.dnd.model.dto.SpeciesDto;
import com.example.dnd.service.SpeciesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/species")
public class SpeciesController {
    private SpeciesService speciesService;

    @PostMapping
    public ResponseEntity<SpeciesDto> createSpecies(@RequestBody SpeciesDto speciesDto) {
        return new ResponseEntity<>(this.speciesService.createSpecies(speciesDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SpeciesDto> getSpeciesById(@PathVariable("id") long id) {
        return ResponseEntity.ok(this.speciesService.getSpeciesById(id));
    }

    @GetMapping
    public ResponseEntity<List<SpeciesDto>> getAllSpecies() {
        return ResponseEntity.ok(this.speciesService.getAllSpecies());
    }

    @PutMapping("{id}")
    public ResponseEntity<SpeciesDto> updateSpecies(@PathVariable("id") Long id, @RequestBody SpeciesDto speciesDto) {
        return ResponseEntity.ok(this.speciesService.updateSpecies(id, speciesDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSpeciesById(@PathVariable("id") Long id) {
        this.speciesService.deleteSpeciesById(id);
        return ResponseEntity.ok("Espécie de ID " + id + " removida com sucesso!");
    }
}
