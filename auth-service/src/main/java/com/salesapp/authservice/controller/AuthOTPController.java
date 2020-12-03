package com.salesapp.authservice.controller;

import com.salesapp.common.dto.Response;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthOTPController {
    @GetMapping("/OTP")
    public Response checkOTP(@RequestParam(value = "otp") String OTP) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return Response.success("OTP authen success" + user);
    }
}
