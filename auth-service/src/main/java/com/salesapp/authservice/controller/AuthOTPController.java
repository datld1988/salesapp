package com.salesapp.authservice.controller;

import com.salesapp.authservice.service.AuthOTPService;
import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthOTPController {
   @Autowired
    private AuthOTPService authOTPService;

    /**
     * author: dungtq
     * mockup api check otp sau login
     * @param OTP
     * @return
     */
    @GetMapping("/OTP")
    public Response checkOTP(@RequestParam(value = "otp") String OTP) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return authOTPService.checkAuthOTP(user, OTP);

    }
}
