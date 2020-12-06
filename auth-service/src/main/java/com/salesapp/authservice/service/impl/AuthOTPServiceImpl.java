package com.salesapp.authservice.service.impl;

import com.salesapp.authservice.service.AuthOTPService;
import com.salesapp.common.dto.Response;
import com.salesapp.common.utils.ErrorCode;
import org.springframework.stereotype.Service;

@Service
public class AuthOTPServiceImpl implements AuthOTPService {
    /**
     * check otp business
     * @param user
     * @param OTP
     * @return
     */
    @Override
    public Response checkAuthOTP(String user, String OTP) {
        if(OTP.equalsIgnoreCase("123456"))
            return Response.success("OTP authen success" + user);
        else
            return Response.error(ErrorCode.AUTHENTICATION, "Unauthentication");
    }
}
