package com.jamiltonquintero.hexagonalmodularmaven.beanconfiguration;

import com.jamiltonquintero.hexagonalmodularmaven.task.port.dao.TaskDao;
import com.jamiltonquintero.hexagonalmodularmaven.task.port.repository.TaskRepository;
import com.jamiltonquintero.hexagonalmodularmaven.task.service.TaskCreateService;
import com.jamiltonquintero.hexagonalmodularmaven.task.service.TaskDeleteService;
import com.jamiltonquintero.hexagonalmodularmaven.task.service.TaskEditService;
import com.jamiltonquintero.hexagonalmodularmaven.task.service.TaskSuperComplexService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskBean {


    @Bean
    public TaskCreateService taskCreateService(TaskRepository taskRepository,
                                               TaskSuperComplexService taskSuperComplexService){
        return new TaskCreateService(taskRepository, taskSuperComplexService);
    }

    @Bean
    public TaskDeleteService taskDeleteService(TaskRepository taskRepository,
                                               TaskDao taskDao){
        return new TaskDeleteService(taskRepository, taskDao);
    }

    @Bean
    public TaskEditService taskEditService(TaskDao taskDao,
                                           TaskRepository taskRepository){
        return new TaskEditService(taskDao, taskRepository);
    }

    @Bean
    public TaskSuperComplexService taskSuperComplexService(){
        return new TaskSuperComplexService();
    }

}
