package com.jamiltonquintero.hexagonalmodularmaven.task.adapter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jamiltonquintero.hexagonalmodularmaven.user.adapter.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean completed;
    private LocalDateTime dateOfCreation;
    private int timeRequiredToComplete;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "taskEntities")
    @JsonBackReference
    private Set<UserEntity> userEntities = new HashSet<>();

    public TaskEntity(String name, String description, boolean completed, LocalDateTime dateOfCreation, int timeRequiredToComplete) {
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.dateOfCreation = dateOfCreation;
        this.timeRequiredToComplete = timeRequiredToComplete;
    }

}
