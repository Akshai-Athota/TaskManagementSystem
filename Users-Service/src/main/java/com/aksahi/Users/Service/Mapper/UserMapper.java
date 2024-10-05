package com.aksahi.Users.Service.Mapper;

import com.aksahi.Users.Service.DTO.UserDTO;
import com.aksahi.Users.Service.Model.UserDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDetails toEntity(UserDTO userDTO);
    UserDTO toDTO(UserDetails user);
}
