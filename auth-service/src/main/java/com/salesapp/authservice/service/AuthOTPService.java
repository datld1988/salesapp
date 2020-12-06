package com.salesapp.authservice.service;

import com.salesapp.common.dto.Response;

public interface AuthOTPService {
    Response checkAuthOTP(String user, String OTP);
}
