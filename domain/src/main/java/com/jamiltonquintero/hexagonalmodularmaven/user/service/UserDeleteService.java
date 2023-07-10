package com.jamiltonquintero.hexagonalmodularmaven.user.service;

import com.jamiltonquintero.hexagonalmodularmaven.user.port.dao.UserDao;
import com.jamiltonquintero.hexagonalmodularmaven.user.port.repository.UserRepository;


public class UserDeleteService {

    private final UserDao userDao;
    private final UserRepository userRepository;

    public UserDeleteService(UserDao userDao, UserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    public void execute(Long id){
        var user = userDao.getById(id);
        userRepository.deleteById(user.getId());
    }

}
