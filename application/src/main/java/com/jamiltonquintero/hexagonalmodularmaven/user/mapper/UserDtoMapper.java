package com.jamiltonquintero.hexagonalmodularmaven.user.mapper;


import com.jamiltonquintero.hexagonalmodularmaven.user.model.dto.UserDto;
import com.jamiltonquintero.hexagonalmodularmaven.user.model.entity.User;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@Component
public interface UserDtoMapper {


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "country", target = "country")
    UserDto toDto(User domain);

}
