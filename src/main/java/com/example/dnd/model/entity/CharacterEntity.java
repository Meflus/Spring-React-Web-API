package com.example.dnd.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "characters")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "character_name")
    private String characterName;

    @Column(name = "character_backstory")
    private String characterBackstory;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "character_level")
    private Integer characterLevel;

    @Column(name = "proficiency_bonus")
    private Integer proficiencyBonus;

    @Column(name = "class_id")
    private Long classEntityId;

    @Column(name = "species_id")
    private Long speciesEntityId;
}
