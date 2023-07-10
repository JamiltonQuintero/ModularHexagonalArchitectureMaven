package com.jamiltonquintero.hexagonalmodularmaven.task.port.dao;

import com.jamiltonquintero.hexagonalmodularmaven.task.model.entity.Task;

import java.util.List;

public interface TaskDao {

    Task getById(Long id);

    List<Task> getAll();

    List<Task> getByIds(List<Long> tasksIds);

}
