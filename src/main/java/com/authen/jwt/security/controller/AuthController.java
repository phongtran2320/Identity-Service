package com.authen.jwt.security.controller;

import com.authen.jwt.security.service.AuthService;
import com.authen.jwt.system.Result;
import com.authen.jwt.system.StatusCode;
import com.authen.jwt.system.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Result getLoginInfo(@RequestBody LoginRequest loginRequest){
        return new Result(true,
                StatusCode.SUCCESS,
                "Userinfo and JWT Token",
                authService.createLoginInfo(loginRequest));
    }
}
