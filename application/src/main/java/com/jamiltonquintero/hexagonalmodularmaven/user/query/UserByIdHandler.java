package com.jamiltonquintero.hexagonalmodularmaven.user.query;


import com.jamiltonquintero.hexagonalmodularmaven.user.mapper.UserDtoMapper;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.UserDto;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserByIdService;
import org.springframework.stereotype.Component;

@Component
public class UserByIdHandler {

    private final UserByIdService userByIdService;
    private final UserDtoMapper userDtoMapper;

    public UserByIdHandler(UserByIdService userByIdService, UserDtoMapper userDtoMapper) {
        this.userByIdService = userByIdService;
        this.userDtoMapper = userDtoMapper;
    }

    public UserDto execute(Long id){
        return userDtoMapper
                .toDto(userByIdService.execute(id));
    }

}
