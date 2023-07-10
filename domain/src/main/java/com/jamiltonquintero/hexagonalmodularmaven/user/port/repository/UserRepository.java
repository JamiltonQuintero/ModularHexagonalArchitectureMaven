package com.jamiltonquintero.hexagonalmodularmaven.user.port.repository;


import com.jamiltonquintero.hexagonalmodularmaven.user.model.entity.User;

public interface UserRepository {

    User create(User user);
    void deleteById(Long id);
    User update(User user);

}
