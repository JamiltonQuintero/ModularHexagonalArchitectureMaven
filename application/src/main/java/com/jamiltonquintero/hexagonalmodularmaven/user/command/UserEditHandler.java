package com.jamiltonquintero.hexagonalmodularmaven.user.command;

import com.jamiltonquintero.hexagonalmodularmaven.user.mapper.UserDtoMapper;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.UserDto;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.command.UserEditCommand;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserEditService;
import org.springframework.stereotype.Component;

@Component
public class UserEditHandler {

    private final UserEditService userEditService;
    private final UserDtoMapper userDtoMapper;

    public UserEditHandler(UserEditService userEditService, UserDtoMapper userDtoMapper) {
        this.userEditService = userEditService;
        this.userDtoMapper = userDtoMapper;
    }

    public UserDto execute(UserEditCommand userEditCommand, Long id){
        return userDtoMapper
                .toDto(userEditService.execute(userEditCommand, id)) ;
    }

}
