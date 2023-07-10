package com.jamiltonquintero.hexagonalmodularmaven.task.command;

import com.jamiltonquintero.hexagonalmodularmaven.task.mapper.TaskDtoMapper;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.TaskDto;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.command.TaskEditCommand;
import com.jamiltonquintero.hexagonalmodularmaven.task.service.TaskEditService;
import org.springframework.stereotype.Component;

@Component
public class TaskEditHandler {
    private final TaskEditService taskEditService;
    private final TaskDtoMapper taskDtoMapper;

    public TaskEditHandler(TaskEditService taskEditService, TaskDtoMapper taskDtoMapper) {
        this.taskEditService = taskEditService;
        this.taskDtoMapper = taskDtoMapper;
    }

    public TaskDto execute(TaskEditCommand taskEditCommand, Long id){
        return taskDtoMapper.toDto(taskEditService.execute(taskEditCommand, id));
    }

}
