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
@Table(name = "features")
public class FeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feature_name")
    private String featureName;

    @Column(name = "feature_description")
    private String featureDescription;

    @Column(name = "level_requirement")
    private Integer levelRequirement;

    @ManyToOne
    @JoinColumn(name="class_id")
    private ClassEntity classEntity;

    @ManyToOne
    @JoinColumn(name="species_id")
    private SpeciesEntity speciesEntity;
}
