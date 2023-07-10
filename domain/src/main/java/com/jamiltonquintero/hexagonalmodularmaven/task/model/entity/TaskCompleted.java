package com.jamiltonquintero.hexagonalmodularmaven.task.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TaskCompleted {

    private static final boolean COMPLETED_DEFAULT_VALUE = false;

    boolean completed;
    public TaskCompleted setCompletedDefaultValue() {
        this.completed = COMPLETED_DEFAULT_VALUE;
        return this;
    }

}
