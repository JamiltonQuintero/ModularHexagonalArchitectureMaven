package com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEditCommand {

    private String name;
    private byte age;
    private String country;

}
