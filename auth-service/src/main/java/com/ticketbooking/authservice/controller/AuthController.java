package com.ticketbooking.authservice.controller;

import com.ticketbooking.authservice.dtos.LoginDto;
import com.ticketbooking.authservice.dtos.LoginResponse;
import com.ticketbooking.authservice.dtos.RefreshTokenRequestDto;
import com.ticketbooking.authservice.dtos.RegisterDto;
import com.ticketbooking.authservice.model.RefreshToken;
import com.ticketbooking.authservice.model.User;
import com.ticketbooking.authservice.service.AuthService;
import com.ticketbooking.authservice.service.JwtService;
import com.ticketbooking.authservice.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final JwtService jwtService;
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDto registerDto) {
        return new ResponseEntity<>(authService.register(registerDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto) {
        loginDto.setEmail(loginDto.getEmail());
        User user = authService.authenticate(loginDto);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(loginDto.getEmail());
        return new ResponseEntity<>(
                LoginResponse.builder()
                        .accessToken(jwtService.generateToken(user))
                        .refreshToken(refreshToken.getToken())
                        .build(),
                HttpStatus.OK
        );
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<LoginResponse> refreshToken(@RequestBody RefreshTokenRequestDto requestDto) {
        return refreshTokenService.findByToken(requestDto.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> new ResponseEntity<>(
                        LoginResponse.builder()
                                .accessToken(jwtService.generateToken(user))
                                .refreshToken(refreshTokenService.createRefreshToken(user.getEmail()).getToken())
                                .build(),
                        HttpStatus.OK
                )).orElseThrow(() -> new RuntimeException("Invalid refresh token"));
    }

    @GetMapping("")
    public ResponseEntity<Void> verify() {
        return ResponseEntity.status(200).build();
    }

}
