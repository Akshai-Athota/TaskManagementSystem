package com.akshai.Gateway.Controller;

import com.akshai.Gateway.Config.UserClient;
import com.akshai.Gateway.DTO.UserDTO;
import com.akshai.Gateway.Model.AuthenticationRequest;
import com.akshai.Gateway.Model.AuthenticationResponse;
import com.akshai.Gateway.Service.JwtService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private UserClient userClient;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signUp")
    public ResponseEntity<?> userSignUp(@RequestBody @Valid UserDTO userDTO){
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        if(userClient.createUser(userDTO) == null){
            return ResponseEntity.badRequest().body("user name already exists");
        }
        return ResponseEntity.ok("registration successful please login");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> userLogin(@RequestBody AuthenticationRequest authenticationRequest){
        final String jwt = jwtService.getToken(authenticationRequest);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
