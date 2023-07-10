package com.jamiltonquintero.hexagonalmodularmaven.user.service;

import com.jamiltonquintero.hexagonalmodularmaven.user.model.entity.User;
import com.jamiltonquintero.hexagonalmodularmaven.user.port.dao.UserDao;

import java.util.List;

public class UserAllService {
    private final UserDao userDao;

    public UserAllService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> execute(){
        return userDao.getAll();
    }

}
