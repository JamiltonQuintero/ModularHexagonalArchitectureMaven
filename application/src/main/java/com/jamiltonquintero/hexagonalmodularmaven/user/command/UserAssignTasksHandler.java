package com.jamiltonquintero.hexagonalmodularmaven.user.command;

import com.jamiltonquintero.hexagonalmodularmaven.user.mapper.UserDtoMapper;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.UserDto;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserAssignTasksService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserAssignTasksHandler {

    private final UserAssignTasksService userAssignTasksService;
    private final UserDtoMapper userDtoMapper;

    public UserAssignTasksHandler(UserAssignTasksService userAssignTasksService, UserDtoMapper userDtoMapper) {
        this.userAssignTasksService = userAssignTasksService;
        this.userDtoMapper = userDtoMapper;
    }

    public UserDto execute(Long id, List<Long> tasksIds){
        return userDtoMapper
                .toDto(userAssignTasksService.execute(id, tasksIds));
    }

}
