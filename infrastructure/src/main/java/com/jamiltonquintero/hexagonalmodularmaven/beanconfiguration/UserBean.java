package com.jamiltonquintero.hexagonalmodularmaven.beanconfiguration;

import com.jamiltonquintero.hexagonalmodularmaven.task.port.dao.TaskDao;
import com.jamiltonquintero.hexagonalmodularmaven.user.port.dao.UserDao;
import com.jamiltonquintero.hexagonalmodularmaven.user.port.repository.UserRepository;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserAllService;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserAssignTasksService;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserByIdService;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserCreateService;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserDeleteService;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserEditService;
import com.jamiltonquintero.hexagonalmodularmaven.user.service.UserValidationAllowTasksAssignmentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBean {
    @Bean
    public UserAllService userAllService(UserDao userDao){
        return new UserAllService(userDao);
    }

    @Bean
    public UserAssignTasksService userAssignTasksService(UserDao userDao,
                                                         TaskDao taskDao,
                                                         UserRepository userRepository,
                                                         UserValidationAllowTasksAssignmentService userValidationAllowTasksAssignmentService){
        return new UserAssignTasksService(
                userDao,
                taskDao,
                userRepository,
                userValidationAllowTasksAssignmentService);
    }

    @Bean
    public UserByIdService userByIdService(UserDao userDao){
        return new UserByIdService(userDao);
    }

    @Bean
    public UserCreateService userCreateService(UserRepository userRepository){
        return new UserCreateService(userRepository);
    }

    @Bean
    public UserDeleteService userDeleteService(UserDao userDao,
                                               UserRepository userRepository){
        return new UserDeleteService(
                userDao,
                userRepository);
    }

    @Bean
    public UserEditService userEditService(UserDao userDao,
                                           UserRepository userRepository){
        return new UserEditService(userDao, userRepository);
    }

    @Bean
    public UserValidationAllowTasksAssignmentService userValidationAllowTasksAssignmentService(){
        return new UserValidationAllowTasksAssignmentService();
    }

}
