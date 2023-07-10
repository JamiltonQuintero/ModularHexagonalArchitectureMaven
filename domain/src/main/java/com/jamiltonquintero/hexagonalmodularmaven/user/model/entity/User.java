package com.jamiltonquintero.hexagonalmodularmaven.user.model.entity;


import com.jamiltonquintero.hexagonalmodularmaven.task.model.entity.Task;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.command.UserCreateCommand;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class User {

    private UserId id;
    private UserName name;
    private UserAge age;
    private UserCountry country;
    private UserTasks tasks;

    public User(Long id, String name, byte age, String country, List<Task> tasks) {
        this.id = new UserId(id);
        this.name = new UserName(name);
        this.age = new UserAge(age);
        this.country = new UserCountry(country);
        this.tasks = new UserTasks(tasks);
    }

    public User(Long id, String name, byte age, String country) {
        this.id = new UserId(id);
        this.name = new UserName(name);
        this.age = new UserAge(age);
        this.country = new UserCountry(country);
    }

    public User requestToCreate(UserCreateCommand userCreateCommand){
        this.name = new UserName(userCreateCommand.getName());
        this.age = new UserAge(userCreateCommand.getAge());
        this.country = new UserCountry(userCreateCommand.getCountry());
        return this;
    }


    public Long getId() {
        return this.id.getId();
    }

    public String getName() {
        return this.name.getName();
    }

    public byte getAge() {
        return this.age.getAge();
    }

    public String getCountry() {
        return this.country.getCountry();
    }

    public List<Task> getTasks() {
        return this.tasks.getTasks();
    }
}
