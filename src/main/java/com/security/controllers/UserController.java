package com.security.controllers;

import com.security.models.User;
import com.security.request.AuthRequest;
import com.security.services.JwtService;
import com.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the profile";
    }

    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody User userInfo) {
        return service.addUser(userInfo);
    }
    @PostMapping("/singin")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

            return jwtService.generateToken(authRequest.getUsername());

    }

}
