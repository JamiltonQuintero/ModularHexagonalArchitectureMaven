package com.jamiltonquintero.hexagonalmodularmaven.task.model.entity;

import com.jamiltonquintero.hexagonalmodularmaven.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TaskUsers {

    List<User> users;

}
