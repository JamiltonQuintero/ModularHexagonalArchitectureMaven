package com.jamiltonquintero.hexagonalmodularmaven.task.query;


import com.jamiltonquintero.hexagonalmodularmaven.task.mapper.TaskDtoMapper;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.TaskDto;
import com.jamiltonquintero.hexagonalmodularmaven.task.port.dao.TaskDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class TaskAllHandler {

    private final TaskDao taskDao;
    private final TaskDtoMapper taskDtoMapper;

    public TaskAllHandler(TaskDao taskDao, TaskDtoMapper taskDtoMapper) {
        this.taskDao = taskDao;
        this.taskDtoMapper = taskDtoMapper;
    }

    public List<TaskDto> execute(){
        return taskDao.getAll()
                .stream()
                .map(taskDtoMapper::toDto)
                .collect(Collectors.toList());
    }

}
