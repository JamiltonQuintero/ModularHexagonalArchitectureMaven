package com.jamiltonquintero.hexagonalmodularmaven.task.service;

import com.jamiltonquintero.hexagonalmodularmaven.task.model.constant.TaskConstant;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.exception.TaskException;
import com.jamiltonquintero.hexagonalmodularmaven.task.port.dao.TaskDao;
import com.jamiltonquintero.hexagonalmodularmaven.task.port.repository.TaskRepository;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.constant.UserConstant;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.exception.UserTaskAssignationException;

public class TaskDeleteService {

    private final TaskRepository taskRepository;
    private final TaskDao taskDao;
    public TaskDeleteService(TaskRepository taskRepository, TaskDao taskDao) {
        this.taskRepository = taskRepository;
        this.taskDao = taskDao;
    }

    public void execute(Long id){

        var task = taskDao.getById(id);

        if(task.getUsers().size() > 0){
            throw new UserTaskAssignationException(
                    String.format(TaskConstant.CURRENT_TASK_NOT_ALLOW_TO_DELETE, task.getName()));
        }
        taskRepository.deleteById(id);
    }

}
