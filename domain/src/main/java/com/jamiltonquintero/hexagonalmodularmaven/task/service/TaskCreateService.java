package com.jamiltonquintero.hexagonalmodularmaven.task.service;

import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.command.TaskCreateCommand;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.entity.Task;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.exception.TaskException;
import com.jamiltonquintero.hexagonalmodularmaven.task.port.repository.TaskRepository;

public class TaskCreateService {

    private final TaskRepository taskRepository;
    private final TaskSuperComplexService taskSuperComplexService;
    public TaskCreateService(TaskRepository taskRepository, TaskSuperComplexService taskSuperComplexService) {
        this.taskRepository = taskRepository;
        this.taskSuperComplexService = taskSuperComplexService;
    }

    public Task execute(TaskCreateCommand createCommand){

        var calculatedTime = taskSuperComplexService.execute();

        if(calculatedTime > createCommand.getTimeRequiredToComplete()){
            throw new TaskException("Super complex exception");
        }

        var taskToCreate = new Task()
                .requestToCreate(createCommand);
        return taskRepository.create(taskToCreate);
    }

}
