package com.jamiltonquintero.hexagonalmodularmaven.task.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDto {

    private Long id;
    private String name;
    private String description;
    private int timeRequiredToComplete;

}
