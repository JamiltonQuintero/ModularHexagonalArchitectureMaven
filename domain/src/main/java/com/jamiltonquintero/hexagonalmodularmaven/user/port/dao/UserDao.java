package com.jamiltonquintero.hexagonalmodularmaven.user.port.dao;


import com.jamiltonquintero.hexagonalmodularmaven.user.model.entity.User;

import java.util.List;

public interface UserDao {

    User getById(Long id);
    List<User> getAll();

}
