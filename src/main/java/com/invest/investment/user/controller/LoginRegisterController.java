package com.invest.investment.user.controller;


import com.invest.investment.user.dto.ApiResponse;
import com.invest.investment.user.dto.LoginDto;
import com.invest.investment.user.dto.RegisterDto;
import com.invest.investment.user.service.LoginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginRegisterController {

    @Autowired
    LoginRegisterService loginRegisterService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegisterDto registerDto){
        ApiResponse apiResponse = loginRegisterService.register(registerDto);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginDto loginDto){
        ApiResponse apiResponse = loginRegisterService.signin(loginDto);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
}
