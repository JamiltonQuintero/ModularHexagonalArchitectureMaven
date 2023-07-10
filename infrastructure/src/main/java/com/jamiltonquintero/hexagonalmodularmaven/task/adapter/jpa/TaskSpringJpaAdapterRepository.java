package com.jamiltonquintero.hexagonalmodularmaven.task.adapter.jpa;


import com.jamiltonquintero.hexagonalmodularmaven.task.adapter.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskSpringJpaAdapterRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findByIdIn(List<Long> tasksIds);

}