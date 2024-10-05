package com.akshai.Gateway.Service;

import com.akshai.Gateway.Config.UserClient;
import com.akshai.Gateway.DTO.UserDTO;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserClient userClient;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = userClient.getUserByName(username).getBody();
        if(userDTO == null) {
            throw new UsernameNotFoundException("no user found with given name"+username);
        }
        return new User(userDTO.getUserName(),userDTO.getPassword(),new ArrayList<>());
    }
}
