package com.jamiltonquintero.hexagonalmodularmaven.task.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TaskDateOfCreation {

    LocalDateTime dateOfCreation;

    public TaskDateOfCreation setDateOfCreationDefaultValue() {
        this.dateOfCreation = LocalDateTime.now();
        return this;
    }
}
