package com.rahmat.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rahmat.auth.model.User;
import com.rahmat.auth.security.JwtUtil;
import com.rahmat.auth.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    //  REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.register(user.getUsername(), user.getPassword());
        return "Register berhasil";
    }

    //  LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (userService.login(user.getUsername(), user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        throw new RuntimeException("Login gagal");
    }
}