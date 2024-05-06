package com.ing.store.api.controller;

import com.ing.store.exception.ApiAuthenticationException;
import com.ing.store.security.JwtUtil;
import com.ing.store.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.AuthenticationApiDelegate;
import org.openapitools.model.JWTokenDto;
import org.openapitools.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationController implements AuthenticationApiDelegate {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public JWTokenDto login(UserDto userDto) {
        log.info("Trying login for username: " + userDto.getUsername());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword())
            );
        } catch (AuthenticationException e) {
            log.error("Login failed for username: " + userDto.getUsername());
            throw new ApiAuthenticationException(userDto.getUsername());

        }
        log.info("Token was generated");
        return JWTokenDto.builder()
                .token(jwtUtil.generateToken(userService.loadUserByUsername(userDto.getUsername())))
                .build();
    }
}
