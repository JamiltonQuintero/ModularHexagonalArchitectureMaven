package com.jamiltonquintero.hexagonalmodularmaven.user.adapter.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jamiltonquintero.hexagonalmodularmaven.task.adapter.entity.TaskEntity;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private byte age;
    private String country;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "user_task",
            joinColumns =  @JoinColumn(name = "user_id", referencedColumnName = "id") ,
            inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"))
    @JsonManagedReference
    private Set<TaskEntity> taskEntities = new HashSet<>();

    public UserEntity(String name, byte age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }
}
