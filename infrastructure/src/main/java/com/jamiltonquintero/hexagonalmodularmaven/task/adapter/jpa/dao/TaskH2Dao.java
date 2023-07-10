package com.jamiltonquintero.hexagonalmodularmaven.task.adapter.jpa.dao;

import com.jamiltonquintero.hexagonalmodularmaven.task.model.exception.TaskException;
import com.jamiltonquintero.hexagonalmodularmaven.task.adapter.jpa.TaskSpringJpaAdapterRepository;
import com.jamiltonquintero.hexagonalmodularmaven.task.adapter.mapper.TaskDboMapper;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.constant.TaskConstant;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.entity.Task;
import com.jamiltonquintero.hexagonalmodularmaven.task.port.dao.TaskDao;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class TaskH2Dao implements TaskDao {

    private final TaskSpringJpaAdapterRepository taskSpringJpaAdapterRepository;
    private final TaskDboMapper taskDboMapper;

    public TaskH2Dao(TaskSpringJpaAdapterRepository taskSpringJpaAdapterRepository, TaskDboMapper taskDboMapper) {
        this.taskSpringJpaAdapterRepository = taskSpringJpaAdapterRepository;
        this.taskDboMapper = taskDboMapper;
    }

    @Override
    public Task getById(Long id) {
        var optionalTask = taskSpringJpaAdapterRepository.findById(id);

        if (optionalTask.isEmpty()){
            throw new TaskException(String.format(TaskConstant.TASK_NOT_FOUND_MESSAGE_ERROR, id));
        }

        return taskDboMapper.toDomain(optionalTask.get());
    }

    @Override
    public List<Task> getAll() {
        return taskSpringJpaAdapterRepository.findAll()
                .stream()
                .map(taskDboMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getByIds(List<Long> tasksIds) {

        return taskSpringJpaAdapterRepository.findByIdIn(tasksIds)
                .stream()
                .map(taskDboMapper::toDomain)
                .collect(Collectors.toList());
    }
}
