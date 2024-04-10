package com.example.dnd.controller;

import com.example.dnd.model.dto.FeatureDto;
import com.example.dnd.service.FeatureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/features")
public class FeatureController {
    private FeatureService featureService;

    @PostMapping
    public ResponseEntity<FeatureDto> createFeature(@RequestBody FeatureDto featureDto) {
        return new ResponseEntity<>(this.featureService.createFeature(featureDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<FeatureDto> getFeatureById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.featureService.getFeatureById(id));
    }

    @GetMapping
    public ResponseEntity<List<FeatureDto>> getAllFeatures() {
        return ResponseEntity.ok(this.featureService.getAllFeatures());
    }

    @PutMapping("{id}")
    public ResponseEntity<FeatureDto> updateFeature(@PathVariable("id") Long id, @RequestBody FeatureDto featureDto) {
        return ResponseEntity.ok(this.featureService.updateFeature(id, featureDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFeature(@PathVariable("id") Long id) {
        this.featureService.deleteFeatureById(id);
        return ResponseEntity.ok("Feature de ID " + id + " removida com sucesso!");
    }
}
