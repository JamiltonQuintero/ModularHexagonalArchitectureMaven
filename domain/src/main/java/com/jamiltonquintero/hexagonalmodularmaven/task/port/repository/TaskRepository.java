package com.jamiltonquintero.hexagonalmodularmaven.task.port.repository;

import com.jamiltonquintero.hexagonalmodularmaven.task.model.entity.Task;


public interface TaskRepository {

    Task create(Task request);
    void deleteById(Long id);
    Task update(Task request);

}
