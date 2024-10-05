package com.aksahi.Users.Service.Service.Impl;

import com.aksahi.Users.Service.DTO.UserDTO;
import com.aksahi.Users.Service.Mapper.UserMapper;
import com.aksahi.Users.Service.Model.UserDetails;
import com.aksahi.Users.Service.Repository.UserRepository;
import com.aksahi.Users.Service.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private  UserRepository userRepository;
    private  UserMapper userMapper;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO updateUser(Long id,UserDTO userDTO) {
        UserDetails user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("no user found"));
        user.builder()
                .userName(userDTO.getUserName())
                .password(userDTO.getPassword())
                .role(userDTO.getRole())
                .build();
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO getUserByUserName(String username) {

        return userMapper.toDTO(userRepository.findByUserName(username)
                .orElseThrow(()->new RuntimeException("user not found exception")));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.toDTO(userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("user not found exception")));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteByUserName(username);
    }
}
