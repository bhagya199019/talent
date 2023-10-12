package com.example.demo.controller;

import com.example.demo.security.UserAuthenticationProvider;
import com.example.demo.service.UserService;
import com.example.demo.dto.CredentialsDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.dto.UserDto;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    
    public AuthController(UserService userService, UserAuthenticationProvider userAuthenticationProvider) {
		super();
		this.userService = userService;
		this.userAuthenticationProvider = userAuthenticationProvider;
	}

	@PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        System.out.println("This method was hit");
		UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto.getEmail()));
        System.out.println(userDto.getToken());
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) throws MessagingException {
        System.out.println(user.getPassword());
    	UserDto createdUser = userService.registerUser(user);
        createdUser.setToken(userAuthenticationProvider.createToken(user.getEmail()));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }
    
    @PostMapping("/signOut")
    public ResponseEntity<Void> signOut(@AuthenticationPrincipal UserDto user) {
    	System.out.println("checking");
        SecurityContextHolder.clearContext();
        return ResponseEntity.noContent().build();
    }

}
