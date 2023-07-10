package com.jamiltonquintero.hexagonalmodularmaven.task.command;

import com.jamiltonquintero.hexagonalmodularmaven.task.mapper.TaskDtoMapper;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.TaskDto;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.command.TaskCreateCommand;
import com.jamiltonquintero.hexagonalmodularmaven.task.service.TaskCreateService;
import org.springframework.stereotype.Component;

@Component
public class TaskCreateHandler {

    private final TaskCreateService taskCreateService;
    private final TaskDtoMapper taskDtoMapper;
    public TaskCreateHandler(TaskCreateService taskCreateService, TaskDtoMapper taskDtoMapper) {
        this.taskCreateService = taskCreateService;
        this.taskDtoMapper = taskDtoMapper;
    }

    public TaskDto execute(TaskCreateCommand createCommand){
        return taskDtoMapper.toDto(taskCreateService.execute(createCommand));
    }

}
