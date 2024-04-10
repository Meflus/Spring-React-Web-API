package com.example.dnd.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpeciesDto {
    private Long id;
    private String speciesName;
    private Integer speciesSize;
    private String speciesDescription;
}
