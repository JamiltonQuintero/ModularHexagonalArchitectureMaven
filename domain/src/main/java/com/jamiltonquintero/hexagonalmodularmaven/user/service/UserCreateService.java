package com.jamiltonquintero.hexagonalmodularmaven.user.service;

import com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.command.UserCreateCommand;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.entity.User;
import com.jamiltonquintero.hexagonalmodularmaven.user.port.repository.UserRepository;

public class UserCreateService {

    private final UserRepository userRepository;

    public UserCreateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UserCreateCommand userCreateCommand){

        var userToCreate = new User()
                .requestToCreate(userCreateCommand);

        return userRepository.create(userToCreate);

    }

}
