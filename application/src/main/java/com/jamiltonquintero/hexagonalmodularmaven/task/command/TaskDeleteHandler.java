package com.jamiltonquintero.hexagonalmodularmaven.task.command;


import com.jamiltonquintero.hexagonalmodularmaven.task.service.TaskDeleteService;
import org.springframework.stereotype.Component;

@Component
public class TaskDeleteHandler {

    private final TaskDeleteService taskDeleteService;

    public TaskDeleteHandler(TaskDeleteService taskDeleteService) {
        this.taskDeleteService = taskDeleteService;
    }

    public void execute(Long id){
        taskDeleteService.execute(id);
    }

}
