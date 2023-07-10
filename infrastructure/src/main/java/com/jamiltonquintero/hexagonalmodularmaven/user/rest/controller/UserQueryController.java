package com.jamiltonquintero.hexagonalmodularmaven.user.rest.controller;

import com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.UserDto;
import com.jamiltonquintero.hexagonalmodularmaven.user.query.UserAllHandler;
import com.jamiltonquintero.hexagonalmodularmaven.user.query.UserByIdHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserQueryController {

    private final UserByIdHandler userByIdHandler;
    private final UserAllHandler userAllHandler;

    public UserQueryController(UserByIdHandler userByIdHandler, UserAllHandler userAllHandler) {
        this.userByIdHandler = userByIdHandler;
        this.userAllHandler = userAllHandler;
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable long id){
        return userByIdHandler.execute(id);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userAllHandler.execute();
    }

}
