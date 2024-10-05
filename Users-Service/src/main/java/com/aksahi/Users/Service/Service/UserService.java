package com.aksahi.Users.Service.Service;

import com.aksahi.Users.Service.DTO.UserDTO;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(Long id,UserDTO userDTO);
    UserDTO getUserByUserName(String username);
    UserDTO getUserById(Long id);
    void deleteUserById(Long id);
    void deleteUser(String username);
}
