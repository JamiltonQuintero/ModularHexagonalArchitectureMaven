package com.jamiltonquintero.hexagonalmodularmaven.user.adapter.jpa.repository;

import com.jamiltonquintero.hexagonalmodularmaven.user.adapter.jpa.UserSpringJpaAdapterRepository;
import com.jamiltonquintero.hexagonalmodularmaven.user.adapter.mapper.UserDboMapper;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.entity.User;
import com.jamiltonquintero.hexagonalmodularmaven.user.port.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserH2Repository implements UserRepository {

    private final UserSpringJpaAdapterRepository userSpringJpaAdapterRepository;
    private final UserDboMapper userDboMapper;

    public UserH2Repository(UserSpringJpaAdapterRepository userSpringJpaAdapterRepository, UserDboMapper userDboMapper) {
        this.userSpringJpaAdapterRepository = userSpringJpaAdapterRepository;
        this.userDboMapper = userDboMapper;
    }

    @Override
    public User create(User user) {
        var userToSave = userDboMapper.toDboCreate(user);
        var userSaved = userSpringJpaAdapterRepository.save(userToSave);
        return userDboMapper.toDomain(userSaved);
    }

    @Override
    public void deleteById(Long id) {
        userSpringJpaAdapterRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        var userToUpdate = userDboMapper.toDbo(user);
        var userUpdated = userSpringJpaAdapterRepository.save(userToUpdate);
        return userDboMapper.toDomain(userUpdated);
    }

}
