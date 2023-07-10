package com.jamiltonquintero.hexagonalmodularmaven.user.command;

import com.jamiltonquintero.hexagonalmodularmaven.user.mapper.UserDtoMapper;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.UserDto;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.command.UserCreateCommand;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserCreateService;
import org.springframework.stereotype.Component;

@Component
public class UserCreateHandler {

    private final UserCreateService userCreateService;
    private final UserDtoMapper userDtoMapper;
    public UserCreateHandler(UserCreateService userCreateService, UserDtoMapper userDtoMapper) {
        this.userCreateService = userCreateService;
        this.userDtoMapper = userDtoMapper;
    }

    public UserDto execute(UserCreateCommand userCreateCommand) {
        return userDtoMapper
                .toDto(userCreateService.execute(userCreateCommand));
    }

}
