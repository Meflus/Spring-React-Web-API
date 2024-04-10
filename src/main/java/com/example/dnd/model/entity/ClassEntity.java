package com.example.dnd.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classes")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "class_hit_die")
    private String classHitDie;

    @Column(name = "class_description")
    private String classDescription;

    @OneToMany(mappedBy = "classEntity")
    private List<CharacterEntity> characters;

    @OneToMany(mappedBy = "classEntity")
    private List<FeatureEntity> features;
}
