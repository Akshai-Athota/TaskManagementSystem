package com.akshai.Gateway.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class AuthenticationResponse {
    private final String jwt;
}
