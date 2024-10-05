package com.akshai.Gateway.Service;

import com.akshai.Gateway.Config.UserClient;
import com.akshai.Gateway.DTO.UserDTO;
import com.akshai.Gateway.Model.AuthenticationRequest;
import com.akshai.Gateway.Utils.JWTUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JwtService {

    private AuthenticationManager authenticationManager;
    private JWTUtils jwtUtils;
    private CustomUserDetailsService userDetailsService;

    public String getToken(AuthenticationRequest authenticationRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUserName(),authenticationRequest.getPassword()
        ));
        final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        return jwtUtils.generateToken(userDetails);
    }

}
