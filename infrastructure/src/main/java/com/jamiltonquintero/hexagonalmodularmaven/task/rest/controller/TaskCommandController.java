package com.jamiltonquintero.hexagonalmodularmaven.task.rest.controller;

import com.jamiltonquintero.hexagonalmodularmaven.task.command.TaskCreateHandler;
import com.jamiltonquintero.hexagonalmodularmaven.task.command.TaskDeleteHandler;
import com.jamiltonquintero.hexagonalmodularmaven.task.command.TaskEditHandler;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.TaskDto;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.command.TaskCreateCommand;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.command.TaskEditCommand;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskCommandController {
    private final TaskCreateHandler taskCreateHandler;
    private final TaskEditHandler taskEditHandler;
    private final TaskDeleteHandler taskDeleteHandler;

    public TaskCommandController(TaskCreateHandler taskCreateHandler, TaskEditHandler taskEditHandler, TaskDeleteHandler taskDeleteHandler) {
        this.taskCreateHandler = taskCreateHandler;
        this.taskEditHandler = taskEditHandler;
        this.taskDeleteHandler = taskDeleteHandler;
    }

    @PostMapping()
    public TaskDto create(@RequestBody TaskCreateCommand createCommand){
        return taskCreateHandler.execute(createCommand);
    }

    @PutMapping("/{id}")
    public TaskDto edit(@RequestBody TaskEditCommand taskEditCommand,
                        @PathVariable Long id){
        return taskEditHandler.execute(taskEditCommand, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        taskDeleteHandler.execute(id);
    }

}
