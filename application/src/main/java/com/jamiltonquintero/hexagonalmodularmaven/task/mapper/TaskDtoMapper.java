package com.jamiltonquintero.hexagonalmodularmaven.task.mapper;


import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.TaskDto;
import com.jamiltonquintero.hexagonalmodularmaven.task.model.entity.Task;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@Component
public interface TaskDtoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "timeRequiredToComplete", target = "timeRequiredToComplete")
    TaskDto toDto(Task domain);

}
