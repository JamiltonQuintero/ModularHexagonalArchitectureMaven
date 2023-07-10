package com.jamiltonquintero.hexagonalmodularmaven.task.service;

import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.command.TaskEditCommand;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.entity.Task;
import com.jamiltonquintero.hexagonalmodularmaven.task.port.dao.TaskDao;
import com.jamiltonquintero.hexagonalmodularmaven.task.port.repository.TaskRepository;

public class TaskEditService {

    private final TaskDao taskDao;
    private final TaskRepository taskRepository;

    public TaskEditService(TaskDao taskDao, TaskRepository taskRepository) {
        this.taskDao = taskDao;
        this.taskRepository = taskRepository;
    }

    public Task execute(TaskEditCommand taskEditCommand, Long id){

        var currentTask = taskDao.getById(id);

        var taskToUpdate = new Task(
                currentTask.getId(),
                taskEditCommand.getName(),
                taskEditCommand.getDescription(),
                currentTask.getCompleted(),
                currentTask.getDateOfCreation(),
                taskEditCommand.getTimeRequiredToComplete(),
                currentTask.getUsers());

        return taskRepository.update(taskToUpdate);

    }

}
