package com.akshai.Gateway.Config;

import com.akshai.Gateway.DTO.UserDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="USERS-SERVICE",path="/api/user")
public interface UserClient {

    @GetMapping("/userName/{userName}")
    ResponseEntity<UserDTO> getUserByName(@PathVariable String userName);

    @PostMapping("/signUp")
    ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO);

}
