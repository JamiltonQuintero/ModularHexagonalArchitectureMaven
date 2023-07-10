package com.jamiltonquintero.hexagonalmodularmaven.user.query;


import com.jamiltonquintero.hexagonalmodularmaven.user.mapper.UserDtoMapper;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.UserDto;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserAllService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class UserAllHandler {

    private final UserAllService userAllService;
    private final UserDtoMapper userDtoMapper;
    public UserAllHandler(UserAllService userAllService, UserDtoMapper userDtoMapper) {
        this.userAllService = userAllService;
        this.userDtoMapper = userDtoMapper;
    }

    public List<UserDto> execute(){
        return userAllService.execute()
                .stream()
                .map(userDtoMapper::toDto)
                .collect(Collectors.toList());
    }

}
