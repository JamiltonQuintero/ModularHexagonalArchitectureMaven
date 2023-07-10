package com.jamiltonquintero.hexagonalmodularmaven.task.model.entity;

import com.jamiltonquintero.hexagonalmodularmaven.task.model.exception.TaskException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TaskName {
    public static final int MAXIMUM_ALLOW_LETTERS = 100;
    String name;

    public TaskName(String name) {
        toValidName(name);
        this.name = name;
    }

    private void toValidName(String name){
        if(name.isEmpty()){
            throw new TaskException("Name is mandatory");
        }

        if(name.length() > MAXIMUM_ALLOW_LETTERS){
            throw new TaskException("Name don't be bigger than 100 characters");
        }

    }

}
