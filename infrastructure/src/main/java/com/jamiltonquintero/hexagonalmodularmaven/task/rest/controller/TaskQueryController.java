package com.jamiltonquintero.hexagonalmodularmaven.task.rest.controller;

import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.TaskDto;
import com.jamiltonquintero.hexagonalmodularmaven.task.query.TaskAllHandler;
import com.jamiltonquintero.hexagonalmodularmaven.task.query.TaskByIdHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskQueryController {

    private final TaskByIdHandler taskByIdHandler;
    private final TaskAllHandler taskAllHandler;

    public TaskQueryController(TaskByIdHandler taskByIdHandler, TaskAllHandler taskAllHandler) {
        this.taskByIdHandler = taskByIdHandler;
        this.taskAllHandler = taskAllHandler;
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id){
        return taskByIdHandler.execute(id);
    }

    @GetMapping
    public List<TaskDto> getAll() {
        return taskAllHandler.execute();
    }

}
