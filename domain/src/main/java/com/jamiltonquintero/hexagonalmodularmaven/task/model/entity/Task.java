package com.jamiltonquintero.hexagonalmodularmaven.task.model.entity;


import com.jamiltonquintero.hexagonalmodularmaven.task.model.dto.command.TaskCreateCommand;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@Getter
public class Task {

    private static final boolean COMPLETED_DEFAULT_VALUE = false;
    private TaskId id;
    private TaskName name;
    private TaskDescription description;
    private TaskCompleted completed;
    private TaskDateOfCreation dateOfCreation;
    private TaskTimeRequiredToComplete timeRequiredToComplete;
    private TaskUsers users;

    public Task(Long id,
                String name,
                String description,
                boolean completed,
                LocalDateTime dateOfCreation,
                int timeRequiredToComplete,
                List<User> users) {
        this.id = new TaskId(id);
        this.name = new TaskName(name);
        this.description = new TaskDescription(description);
        this.completed = new TaskCompleted(completed);
        this.dateOfCreation = new TaskDateOfCreation(dateOfCreation);
        this.timeRequiredToComplete = new TaskTimeRequiredToComplete(timeRequiredToComplete);
        this.users = new TaskUsers(users);
    }

    public Task(Long id,
                String name,
                String description,
                boolean completed,
                LocalDateTime dateOfCreation,
                int timeRequiredToComplete) {
        this.id = new TaskId(id);
        this.name = new TaskName(name);
        this.description = new TaskDescription(description);
        this.completed = new TaskCompleted(completed);
        this.dateOfCreation = new TaskDateOfCreation(dateOfCreation);
        this.timeRequiredToComplete = new TaskTimeRequiredToComplete(timeRequiredToComplete);
    }

    public Task requestToCreate(TaskCreateCommand taskCreateCommand){
        this.name = new TaskName(taskCreateCommand.getName());
        this.description = new TaskDescription(taskCreateCommand.getDescription());
        this.completed = new TaskCompleted().setCompletedDefaultValue();
        this.dateOfCreation = new TaskDateOfCreation().setDateOfCreationDefaultValue();
        this.timeRequiredToComplete = new TaskTimeRequiredToComplete(taskCreateCommand.getTimeRequiredToComplete());
        return this;
    }

    public Long getId() {
        return id.getId();
    }

    public String getName() {
        return name.getName();
    }

    public String getDescription() {
        return description.getDescription();
    }

    public boolean getCompleted() {
        return completed.isCompleted();
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation.getDateOfCreation();
    }

    public int getTimeRequiredToComplete() {
        return timeRequiredToComplete.getTimeRequiredToComplete();
    }

    public List<User> getUsers() {
        return users.getUsers();
    }


}
