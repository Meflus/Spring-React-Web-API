package com.example.dnd.controller;

import com.example.dnd.model.dto.ClassDto;
import com.example.dnd.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/classes")
public class ClassController {
    private ClassService classService;

    @PostMapping
    public ResponseEntity<ClassDto> createClass(@RequestBody ClassDto classDto) {
        return new ResponseEntity<>(this.classService.createClass(classDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClassDto> getClassById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.classService.getClassById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClassDto>> getAllClasses() {
        return ResponseEntity.ok(this.classService.getAllClasses());
    }

    @PutMapping("{id}")
    public ResponseEntity<ClassDto> updateClass(@PathVariable("id") Long id, @RequestBody ClassDto classDto) {
        return ResponseEntity.ok(this.classService.updateClass(id, classDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteClass(@PathVariable("id") Long id) {
        this.classService.deleteClassById(id);
        return ResponseEntity.ok("Classe de ID " + id + " removida com sucesso!");
    }
}
