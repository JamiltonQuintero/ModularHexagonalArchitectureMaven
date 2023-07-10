package com.jamiltonquintero.hexagonalmodularmaven.user.model.entity;

import com.jamiltonquintero.hexagonalmodularmaven.task.model.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserTasks {

    private List<Task> tasks;

}
