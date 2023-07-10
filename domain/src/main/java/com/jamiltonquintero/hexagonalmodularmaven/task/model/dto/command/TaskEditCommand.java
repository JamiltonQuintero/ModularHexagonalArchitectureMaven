package com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskEditCommand {

    private String name;
    private String description;
    private int timeRequiredToComplete;

}
