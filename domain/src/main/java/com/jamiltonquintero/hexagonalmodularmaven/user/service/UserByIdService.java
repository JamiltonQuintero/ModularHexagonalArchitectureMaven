package com.jamiltonquintero.hexagonalmodularmaven.user.service;


import com.jamiltonquintero.hexagonalmodularmaven.user.model.entity.User;
import com.jamiltonquintero.hexagonalmodularmaven.user.port.dao.UserDao;

public class UserByIdService {
    private final UserDao userDao;

    public UserByIdService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User execute(Long id){
        return userDao.getById(id);
    }

}
