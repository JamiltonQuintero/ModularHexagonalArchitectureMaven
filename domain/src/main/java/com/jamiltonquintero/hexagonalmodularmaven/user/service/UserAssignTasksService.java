package com.jamiltonquintero.hexagonalmodularmaven.user.service;

import com.jamiltonquintero.hexagonalmodularmaven.task.port.dao.TaskDao;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.entity.User;
import com.jamiltonquintero.hexagonalmodularmaven.user.port.dao.UserDao;
import com.jamiltonquintero.hexagonalmodularmaven.user.port.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserAssignTasksService {
    private final UserDao userDao;
    private final TaskDao taskDao;
    private final UserRepository userRepository;
    private final UserValidationAllowTasksAssignmentService userValidationAllowTasksAssignmentService;

    public UserAssignTasksService(UserDao userDao, TaskDao taskDao, UserRepository userRepository, UserValidationAllowTasksAssignmentService userValidationAllowTasksAssignmentService) {
        this.userDao = userDao;
        this.taskDao = taskDao;
        this.userRepository = userRepository;
        this.userValidationAllowTasksAssignmentService = userValidationAllowTasksAssignmentService;
    }

    public User execute(Long id, List<Long> tasksIds){

        var user = userDao.getById(id);

        var tasksToDo = taskDao.getByIds(tasksIds);

        userValidationAllowTasksAssignmentService
                .execute(new ArrayList<>(user.getTasks()), tasksToDo);

        user.getTasks().addAll(tasksToDo);

       return userRepository.update(user);
    }

}
