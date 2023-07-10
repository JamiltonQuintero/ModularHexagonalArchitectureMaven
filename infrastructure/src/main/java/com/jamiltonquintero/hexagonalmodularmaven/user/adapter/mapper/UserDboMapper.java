package com.jamiltonquintero.hexagonalmodularmaven.user.adapter.mapper;

import com.jamiltonquintero.hexagonalmodularmaven.task.adapter.entity.TaskEntity;
import com.jamiltonquintero.hexagonalmodularmaven.task.adapter.mapper.TaskDboMapper;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.entity.Task;
import com.jamiltonquintero.hexagonalmodularmaven.user.adapter.entity.UserEntity;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.entity.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDboMapper {

    private final TaskDboMapper taskDboMapper;

    public UserDboMapper(@Lazy TaskDboMapper taskDboMapper) {
        this.taskDboMapper = taskDboMapper;
    }

    public UserEntity toDbo(User domain){
        if(domain == null){
            return null;
        }

        Set<TaskEntity> taskEntities = domain.getTasks().stream().map(taskDboMapper::toDbo).collect(Collectors.toSet());

        return new UserEntity(domain.getId(), domain.getName(), domain.getAge(), domain.getCountry(),taskEntities);
    }
    public UserEntity toDboCreate(User domain){
        if(domain == null){
            return null;
        }
        return new UserEntity(domain.getName(), domain.getAge(), domain.getCountry());
    }

    public User toDomain(UserEntity entity){
        if(entity == null){
            return null;
        }

        List<Task> tasks = entity.getTaskEntities().stream().map(taskDboMapper::toDomainWithOutUser).collect(Collectors.toList());

        return new User(entity.getId(), entity.getName(), entity.getAge(), entity.getCountry(),tasks);
    }

    public User toDomainWithOutTask(UserEntity entity){
        if(entity == null){
            return null;
        }
        return new User(entity.getId(), entity.getName(), entity.getAge(), entity.getCountry());
    }

}
